#include "stdafx.h"

float fac(int n);

void main()
{
	printf("%f\n", fac(3));	
}

float fac(int n)
{
	if(n == 0 || n == 1)
		return 1;
	else
		return n*fac(n-1);
}