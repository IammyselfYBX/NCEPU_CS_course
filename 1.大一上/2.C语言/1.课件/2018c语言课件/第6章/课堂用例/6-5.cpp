/* 在数组中查找一个给定的数 */
#include <stdio.h>
void main()
{
	int i,flag,x;  /* 定义flag变量，用于指示是否查找到那个给定的数 */
	int a[10]={22,19,36,80,98,12,20,55,-8,16};   /* 定义并初始化数组 */
	/*输出数组*/
	for(i=0;i<10;i++)
		printf("%d ",a[i]);
	printf("\n");
	
	printf("Enter x:\n");
	scanf("%d",&x);        
	flag=0;            /* 查询前给flag赋值为0，表示没有查询到x */
	for(i=0;i<10;i++)
		if(a[i]==x)    /* 如果在数组a中找到了x */
		{
			printf("Index is %d\n",i);
			flag=1;     /* 给flag赋值为1，表示在数组a中找到了x */
			break;      /* 跳出循环 */
		}
		
		if(flag==0)         /* 查询结束后，如果flag值为0，表示数组a中没有x */
			printf("Not Found\n");
}
