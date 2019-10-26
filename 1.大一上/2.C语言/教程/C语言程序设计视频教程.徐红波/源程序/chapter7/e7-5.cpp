#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a[3][4]={1,2,3,4,5,6,7,8};

	int max, row, column;

	max=a[0][0];
	row=0;
	column=0;

	for(int i=0; i<3; i++)
		for(int j=0; j<4; j++)
		{
			if(a[i][j]>max)
			{
				max=a[i][j];
				row=i;
				column=j;
			}
		}

	printf("max=%d row=%d column=%d\n", max, row, column);

	printf("%d\n", a[row][column]);


	return 0;
}