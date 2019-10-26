#include "stdafx.h"

int main(int argc, char* argv[])
{
	int * p; 
	int a[10];

	p=a;
	for(int i=0; i<10; i++)
	{
		scanf("%d", p);
		p++;
	}

	p=a;
	for(i=0; i<10; i++)
	{
		printf("%d ", *p);
		p++;
	}

}