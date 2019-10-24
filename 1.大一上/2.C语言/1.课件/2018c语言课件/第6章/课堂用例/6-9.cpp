/* 二维数组的输入和输出 */
#include <stdio.h>
void main()
{
    int i,j;
	int a[3][3];  /* 定义二维数组a为3行3列的整型数组 */
    
	printf("输入3×3阶数组\n");
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			scanf("%d",&a[i][j]); /* 从键盘读入数据，并给二维数组中的相应元素赋值 */
		
		printf("输出3×3阶数组\n");
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++) 
				printf("%3d",a[i][j]); /* 将二维数组中的相应元素输出在屏幕上 */
			printf("\n"); /* 输出结束时换行 */
		}
}
