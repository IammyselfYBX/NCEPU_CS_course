#include "stdafx.h"

int max(int b[3][4]);

void main()
{
	int a[3][4]={{0,1,2},{3,4,5},{6,7,8}};

	printf("max is %d\n", max(a));
}

int max(int b[][4])
{
	int max=b[0][0];

	for(int i=0; i<3; i++)
		for(int j=0; j<4; j++)
			if(b[i][j] > max)
				max=b[i][j];

	return max;
}