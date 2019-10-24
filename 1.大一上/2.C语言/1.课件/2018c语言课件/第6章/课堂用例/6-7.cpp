/* 冒泡法排序 */
#include <stdio.h>
void main()
{
	int i,j,t,n;
	int a[10];  
	
	printf("Enter n:\n");
	scanf("%d",&n); 
	printf("Enter %d integers:\n",n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);  
	
	/* 对数组a中的n个元素冒泡法排序 */
	for(i=0;i<n-1;i++)
		for(j=0;j<n-i-1;j++)
			if(a[j]>a[j+1])
			{
				t=a[j];
				a[j]=a[j+1];
				a[j+1]=t;
			}
			
			/* 输出排序后的结果 */
			printf("After sorted:\n");
			for(i=0;i<n;i++)
				printf("%d  ",a[i]);
			printf("\n");
			
}
