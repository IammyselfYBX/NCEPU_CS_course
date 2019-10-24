/* 计算某个日期对应该年的第几天 */
#include <stdio.h>
void main()
{
	int Year,Month,Day;
	int days=0;
    int day_of_year(int Year, int Month, int Day); /* 函数声明 */
	
	printf("请输入年、月、日：\n");
	scanf("%d%d%d",&Year,&Month,&Day); /* 获得Year,Month,Day的值 */
	
    days=day_of_year(Year,Month,Day); /* 函数调用 */
	printf("%d年%d月%d日是该年的第%d天\n",Year,Month,Day,days);
}

int day_of_year(int year,int month,int day )
{
	int k,leap;
	int tab[2][13]={  /* 定义tab为2行13列的整型数组 */
		{0,31,28,31,30,31,30,31,31,30,31,30,31}, /* 数组第0行为非闰年每月天数 */
		{0,31,29,31,30,31,30,31,31,30,31,30,31}  /* 数组第1行为闰年每月天数 */
	};
	
	leap=((year%4==0)&&(year%100!=0)||(year%400==0));  /* 判断所求年份是否为闰年 */
	for(k=0;k<month;k++)
		day=day+tab[leap][k];  /* 计算该日期为该年的第几天 */
	return day;
}
