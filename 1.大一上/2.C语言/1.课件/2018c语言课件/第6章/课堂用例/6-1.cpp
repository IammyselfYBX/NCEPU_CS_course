#include <stdio.h>
void main()
{
	int i,n=0;
	float a[10];    /* 定义一个数组，用来存放10个数 */
	float avg=0;    /* 定义一个变量，用来存放这10个数的平均值*/
	
	printf("请输入10个数：\n");   /* 提示输入10个数 */
	/* 读入10个数，并求这些数的和 */
	for(i=0;i<10;i++)
	{
		scanf("%f",&a[i]);
		avg+=a[i];
	}
    
	avg=avg/10;        /* 求这10个数的平均值 */
	printf("平均值为：%f\n",avg); 
	/* 输出大于平均值的值 */
	for(i=0;i<10;i++)
		if(a[i]>avg)
		{
			printf("%f  ",a[i]);
			n++;
			if(n%5==0)
				printf("\n");
		}
		printf("\n");
}
