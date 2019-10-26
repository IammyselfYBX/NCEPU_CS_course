#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a[3][4]={0,1,2,3,4,5,6,7,8,9,10,11};

	int (*p)[4];

	p=a;

	int i, j;

	scanf("%d %d", &i, &j);

	printf("%d\n", *(*(p+i)+j));//*(*(p+i)+j)==a[i][j]

	return 0;
}