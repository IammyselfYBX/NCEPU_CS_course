/*交换两个变量的数值*/
#include "stdio.h"
void swap(int x, int y);
void main(void)
{
	int a,b;
	printf("请输入交换的数值：");
	scanf("%d%d",&a, &b);                    /*读入数值*/

	printf("交换前a=%d,b=%d\n",a, b);
	swap(a,b);                               /*调用函数*/
	printf("交换后a=%d,b=%d\n",a, b);
}

void swap(int x, int y)                      /*交换函数定义*/
{
  int temp;
  temp = x;
  x = y;
  y = temp;
}
