#include <stdio.h>
int main()
{
	int i=0,k=0;
	int a[10]={0}; /* 定义有10个元素的整型数组，并初始化各元素值为0 */
    
	/* 读入数组a各元素的值，并输出 */
	printf("Please input data:\n");
	for(i=0;i<10;i++)
	{
		scanf("%d",&a[i]);
		printf("%4d",a[i]);
	}
	printf("\n");
	
	/* 寻找并记录数组中最大值元素的位置 */
	k=0;
	for(i=1;i<10;i++)
		if(a[k]<a[i])  /* 用k来记录数组中最大值元素的位置 */
			k=i;
		
		printf("k=%d\n",k); /* 输出数组中最大值元素的位置 */
	return 0;
}
