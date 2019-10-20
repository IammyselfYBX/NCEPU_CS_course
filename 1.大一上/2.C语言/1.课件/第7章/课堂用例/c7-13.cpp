/*汉诺塔问题*/
#include "stdio.h"
/*将n个盘子从a移动到c，借助b*/
void hanio(int n, char a, char b, char c);    /*函数声明*/

void main(void)
{
	int n;
	printf("输入汉诺塔盘子的个数：\n");      
	scanf("%d", &n);                    /*读入数值*/
	printf("移动的步骤为：\n");
	hanio(n, 'a', 'b', 'c');                  /*函数调用*/
}

void hanio(int n, char a, char b, char c)     /*函数定义*/
{
	if(n == 1)
		printf("%c-->%c\n",a,c);
	else
	{
		hanio(n-1, a, c, b);          /*将n-1盘子从a移动到b，借助c*/
		printf("%c-->%c\n", a, c);    /*将n盘子从a移动到c*/
		hanio(n-1, b, a, c);          /*将n-1盘子从b移动到c，借助a*/
	}
}
