/*关系运算符示例*/
#include "stdio.h"
void main(void)
{
	char c = 'k';
	int i = 1, j = 2, k = 3;
	float x = 1000, y = 0.85;
	printf("%3d", 'a' + 5 < c);
	printf("%3d", -i - 2*j >= k + 1);
	printf("%3d", 1 < j < 5);
	printf("%3d", x - 5.25 <= x + y);
	printf("%3d", i + j + k == -2*j);
	printf("%3d", j-1 == i != k);
	printf("%3d\n", k == j == i + 5);
}
