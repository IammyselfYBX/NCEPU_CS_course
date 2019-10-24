#include <stdio.h>
void main()
{
	int x, y;
	x=1/2;          /* 整型运算量的除法运算，其结果自动取整 */
	y=5%2;         /* %为求余运算，其运算量只能是整数*/
	printf("x=%d,y=%d\n", x, y);
}
