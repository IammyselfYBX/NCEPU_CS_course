#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a[5]={1,2,3,4,5};

	int * num[5]={&a[0],&a[1],&a[2],&a[3],&a[4]};

	int ** p;

	p=num;

	for(int i=0; i<5; i++)
	{
		printf("%d ", **p);
		p++;
	}



	


	return 0;
}