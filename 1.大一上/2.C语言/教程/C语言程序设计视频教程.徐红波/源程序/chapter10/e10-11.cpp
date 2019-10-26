#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a[3][4]={0,1,2,3,4,5,6,7,8,9,10,11};

	int * p;

	for(p=a[0];p<=a[0]+11;p++)
	{
		if((p-a[0]) % 4 == 0)
			printf("\n");
		printf("%d ", *p);
	}
	printf("\n");

	return 0;
}