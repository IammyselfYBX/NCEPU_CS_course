/*编写函数计算整数的阶乘*/
#include "stdio.h"
double fact(int n);                             /*函数声明*/

void main(void)
{
	int n;
	printf("输入一个整数：\n");                 /*读入数值*/
	scanf("%d",&n);                         
	printf("%d!的阶乘是：%.1f\n", n, fact(n));  /*函数调用*/
}

double fact(int n)                              /*函数定义*/
{
	double result;
	if(n == 1||n == 0)
		result = 1;
	else
		result = n*fact(n-1);                   /*函数递归调用*/
	return result;                   
}
