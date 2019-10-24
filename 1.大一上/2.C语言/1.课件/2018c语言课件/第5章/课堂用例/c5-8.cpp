/*读入一个整数，将其第5位取反*/
#include "stdio.h"
void main(void)
{
	int i;
	printf("输入一个整数：");
	scanf("%d", &i);
	i = i^16;        /*16=00000000 00010000*/
	printf("取反后的值为：%d", i);
}
