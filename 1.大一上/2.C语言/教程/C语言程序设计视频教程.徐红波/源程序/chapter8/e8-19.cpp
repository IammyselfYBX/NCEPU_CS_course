#include "stdafx.h"

double fac(long n);

void main()
{
	long i, n;
	scanf("%ld", &n);
	for(i=1; i<=n; i++)
		printf("%ld!=%e\n", i, fac(i));
	
}

double fac(long n)
{
	register long i;
	register double f=1.0;
	for(i=1; i<=n; i++)
		f=f*i;
	return f;
}
