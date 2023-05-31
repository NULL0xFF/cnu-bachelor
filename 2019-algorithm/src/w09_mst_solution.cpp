#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;
typedef long long ll;
int v, e, p[50050], c[200020], par[50050][22], g[50050][22], h[50050], x, y, z, f, cnt;
vector<pair<int, pair<int, int>>> vt;
vector<vector<pair<int, int>>> mst;
int find(int h)
{
    // return h == p[h] ? h : p[h] = find(p[h]);
    if (h == p[h])
        return h;
    else
        return p[h] = find(p[h]);
}
bool merge(int x, int y, int z)
{
    if (find(x) == find(y))
        return false;
    mst[x].push_back({y, z});
    mst[y].push_back({x, z});
    f += z;
    p[find(x)] = find(y);
    return true;
}
void dfs(int curr, int prev)
{
    for (auto next : mst[curr])
    {
        if (next.first == prev)
            continue;
        h[next.first] = h[curr] + 1;
        par[next.first][0] = curr;
        g[next.first][0] = next.second;
        dfs(next.first, curr);
    }
}
int bsch(int x, int y, int z)
{
    if (y == 0)
        return 0;
    int ret = 0;
    if (g[x][y - 1] == z)
        ret = max(ret, bsch(x, y - 1, z));
    else
        ret = max(ret, g[x][y - 1]);
    if (g[par[x][y - 1]][y - 1] == z)
        ret = max(ret, bsch(par[x][y - 1], y - 1, z));
    else
        ret = max(ret, g[par[x][y - 1]][y - 1]);
    return ret;
}
int getmax(int x, int y, int z)
{
    if (h[x] > h[y])
        swap(x, y);
    int ret = 0;
    for (int i = 20; i >= 0; i--)
    {
        if ((h[y] - h[x]) >= (1 << i))
        {
            if (g[y][i] == z)
                ret = max(ret, bsch(y, i, z));
            else
                ret = max(ret, g[y][i]);
            y = par[y][i];
        }
    }
    if (x == y)
        return ret;
    for (int i = 20; i >= 0; i--)
    {
        if (par[x][i] != par[y][i])
        {
            if (g[x][i] == z)
                ret = max(ret, bsch(x, i, z));
            else
                ret = max(ret, g[x][i]);
            if (g[y][i] == z)
                ret = max(ret, bsch(y, i, z));
            else
                ret = max(ret, g[y][i]);
            x = par[x][i];
            y = par[y][i];
        }
    }
    if (g[x][0] != z)
        ret = max(ret, g[x][0]);
    if (g[y][0] != z)
        ret = max(ret, g[y][0]);
    return ret;
}
// int v, e, p[50050], c[200020], par[50050][22], g[50050][22], h[50050], x, y, z, f, cnt;
// vector<pair<int, pair<int, int>>> vt;
// vector<vector<pair<int, int>>> mst;
int main()
{
    scanf("%d%d", &v, &e);
    mst.resize(v + 1);
    for (int i = 1; i <= v; i++)
        p[i] = i;
    for (int i = 0; i < e; i++)
    {
        scanf("%d%d%d", &x, &y, &z);
        vt.push_back({z, {x, y}});
    }
    sort(vt.begin(), vt.end());
    for (int i = 0; i < e; i++)
    {
        if (merge(vt[i].second.first, vt[i].second.second, vt[i].first))
        {
            c[i]++;
            cnt++;
        }
        if (cnt == v - 1)
            break;
    }
    if (cnt != v - 1 || e <= v - 1)
    {
        puts("-1");
        return 0;
    }
    dfs(1, 0);
    for (int j = 1; j < 21; j++)
    {
        for (int i = 1; i <= v; i++)
        {
            par[i][j] = par[par[i][j - 1]][j - 1];
            g[i][j] = max(g[par[i][j - 1]][j - 1], g[i][j - 1]);
        }
    }
    ll r = 1e11;
    for (int i = 0; i < e; i++)
    {
        if (c[i])
            continue;
        int gmax = getmax(vt[i].second.first, vt[i].second.second, vt[i].first);
        if (!gmax)
            continue;
        r = min(r, (ll)(f - gmax + vt[i].first));
    }
    if (r == 1e11 || r == f)
        puts("-1");
    else
        printf("%lld\n", r);
    return 0;
}