#include "stdafx.h"

float p(int n, float x);

void main()
{
	int n=1;
	float x=2.0;

	printf("%f\n", p(2, x));

	//(6-2-1)/2
}

float p(int n, float x)
{
	if(n==0)
		return 1;
	else if(n==1)
		return x;
	else
		return ((2*n-1)*x-p(n-1, x)-(n-1)*p(n-2, x))/n;
}