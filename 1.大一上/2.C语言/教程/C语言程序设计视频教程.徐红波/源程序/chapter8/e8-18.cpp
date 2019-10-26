#include "stdafx.h"

void main()
{

	int fac(int n);
	//int i;
	for(int i=1; i<=5; i++)
		printf("%d!=%d\n", i, fac(i));
	
}

int fac(int n)
{
	static int f=1;
	f=f*n;
	return f;
}