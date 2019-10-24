#include <stdio.h>
void main(void)
{
	int i,j,k,n,temp;
	int a[6][6];
	
	/*给二位数组赋值*/
	printf("Enter n:");
	scanf("%d",&n);
	for(k=1,i=0;i<n;i++)
		for(j=0;j<n;j++)
			a[i][j]=k++;  /* 给数组元素赋值 */
		
		/*  输出原矩阵 */
		printf("原矩阵:\n");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
				printf("%4d",a[i][j]);
			printf("\n");
		}
		/*行列互换*/
		for(i=1;i<n;i++)
			for(j=0;j<i;j++) /* 只遍历下三角矩阵 */
			{
				temp=a[i][j];  /* 交换a[i][j]和a[j][i] */
				a[i][j]=a[j][i];
				a[j][i]=temp;
			}
			
			/* 输出转置矩阵 */
			printf("转置矩阵\n");
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
					printf("%4d",a[i][j]);
				printf("\n");
			}
}
