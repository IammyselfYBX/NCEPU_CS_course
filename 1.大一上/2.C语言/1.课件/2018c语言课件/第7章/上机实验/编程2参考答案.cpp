#include <stdio.h>
void max_value(int array[][4])
{
	int i,j,max=array[0][0],iIndex=0,jIndex=0;
	for(i=0;i<3;i++)
		for(j=0;j<4;j++)
			if(max<array[i][j]) 
			{
				iIndex = i;
				jIndex = j;
				max = array[i][j];
			}
	printf("Max=array[%d][%d]=%d\n",iIndex,jIndex,max);
}       

void main()
{
	int a[3][4]={{1,2,3,4},
				{8,7,6,5},
				{9,10,11,12}};

	max_value(a);
}
