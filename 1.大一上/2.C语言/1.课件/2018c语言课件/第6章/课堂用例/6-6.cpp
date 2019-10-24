/* 选择法排序 */
#include <stdio.h>
void main()
{
	int i,index,k,n,temp;
	int a[10];      /* 定义一个数组a，它包含10个整型元素 */
	
	printf("Enter n:\n");
	scanf("%d",&n);         /* 读入数组a中元素的个数 */
	printf("Enter %d integers:\n",n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);     /* 依次读入数组中的元素值 */
	
	/* 对数组a中的n个元素排序 */
	for(k=0;k<n-1;k++)
	{
		/* index为每一轮排序时最小元素的下标。在每一轮排序前，将index设定为该轮参与排序的第一个元素下标 */
		index=k;
		for(i=k+1;i<n;i++)
			if(a[i]<a[index])   /* 发现比a[index]小的元素，就修改index值 */
				index=i;
			
			/* 在该轮比较结束后，将a[index]与a[k]互换 */
			temp=a[index];
			a[index]=a[k];
			a[k]=temp;
	}
	
	/* 输出排序后的结果 */
	printf("After sorted:\n");
	for(i=0;i<n;i++)
		printf("%d  ",a[i]);
	printf("\n");
}
