/*编写函数计算最大公约数和最小公倍数*/
#include "stdio.h"

int gys(int a, int b);        /*函数声明*/
int gbs(int a, int b);        /*函数声明*/

void main(void)
{
	int x, y;
	printf("输入两个整数：\n");
	scanf("%d%d",&x,&y);
	printf("%d和%d的最大公约数是：%d", x, y, gys(x, y));
    printf("，最小公倍数是%d\n", gbs(x, y));
}

int gys(int a, int b)        /*函数定义*/
{
	int t;
	t = a%b;                 /*辗转相除法计算最大公约数*/
	while(t != 0)
	{
		a = b;
		b = t;
		t = a%b;
	}
	return b;
}

int gbs(int a, int b)        /*函数定义*/
{
	int t;
	t = a*b/gys(a,b);        /*函数调用*/
	return t;
}
