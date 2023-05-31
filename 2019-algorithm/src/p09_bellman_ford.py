# for v in V:
#     v.distance = infinity
#     v.p = None
# source.distance = 0
# for i from 1 to |v| - 1:
#     for (u, v) in E:
#         relax(u, v)

# relax(u, v):
#     if v.distance > u.distance + weight(u, v):
#         v.distance = u.distance + weight(u, v)
#         v.p = u