#include "stdio.h"
void main(void)
{
	int year;
	printf("输入一个年份：");
	scanf("%d", &year);
	if((year%4 == 0) && (year%100 != 0) || (year%400 == 0))
		printf("该年份是闰年\n");
	else
		printf("该年份不是闰年\n");
}
