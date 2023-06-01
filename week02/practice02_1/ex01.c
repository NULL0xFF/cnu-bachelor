// 201802162 지명하

#include <stdio.h>

int main() {
	int a = 6, b = 2;
	int result = 0;

	result = funcMul(a, b);
	printf("%d * %d = %d\n", a, b, result);
        result = funcDiv(a, b);
        printf("%d / %d = %d\n", a, b, result);
	return 0;
}
