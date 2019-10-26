#include "stdafx.h"

float add(float, float);

void main()
{
	float a, b, c;
	scanf("%f,%f", &a, &b);

	c=add(a, b);

	printf("sum is %f\n", c);	
}

float add(float x, float y)
{
	float z;
	z=x+y;
	return (z);
}

