#include "stdio.h"
void main(void)
{
	int num;
	void pyramid(int n);                   /*函数声明*/

	printf("请输入金字塔的层数：");        /*提示语言*/
	scanf("%d",&num);                      /*读入金字塔层数*/

	pyramid(num);                          /*调用函数，输出数字金字塔*/
}

void pyramid(int n)                        /*函数定义*/
{
	int i, j;
	for(i = 1;i <= n; i++)                  /*金字塔层数*/
	{
		for(j = 1;j <= n-i; j++)           /*输出每行左边的空格数*/
			printf(" ");

		for(j = 1;j <= i; j++)             /*输出每行的数字*/
			printf("%d ",i);
		printf("\n");                      /*换行*/
	}
}
