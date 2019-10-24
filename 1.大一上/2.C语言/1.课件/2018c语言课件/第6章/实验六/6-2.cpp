#include <stdio.h>
#define ROW 2
#define COL 3


int main()
{
	int a[ROW][COL]={1,4,6,8,10,12};
	int i,j,temp;


	for(i=0;i<ROW;i++)
	{
		temp=a[i][COL-1];
		for(j=COL-2;j>=0;j--)
		{
			a[i][j]=a[i][j+1];      /*调试时设置断点*/
		}
		a[i][0]=temp;           /*调试时设置断点*/
	}


	for(int i=0;i<ROW;i++)
	{

		for(j=0;j<COL;j++)
			printf("%6d",a[i][j]);
		printf("\n");
	}
	return 0;
}
