/* 找出矩阵中的最大值及其行下标和列下标 */
#include <stdio.h>
void main()
{
	int col,i,j,row;
	int a[3][2];  /* 定义a为3行2列的整型二维数组 */
	
	printf("Enter 6 integers:\n");
	for(i=0;i<3;i++)
		for(j=0;j<2;j++)
			scanf("%d",&a[i][j]); 
		
		/* 按矩阵的形式输出二维数组 */
		for(i=0;i<3;i++)
		{
			for(j=0;j<2;j++)
				printf("%4d",a[i][j]); 
			printf("\n");
		}
		
		/* 遍历二维数组，找出最大值a[row][col] */
		row=0;
		col=0;
		for(i=0;i<3;i++)
			for(j=0;j<2;j++)
				if(a[i][j]>a[row][col]) /* 遍历过程中，如果a[i][j]比当前的最大值大 */
				{
					row=i;
					col=j;
				}
				printf("max=a[%d][%d]=%d\n",row,col,a[row][col]);
				
}
