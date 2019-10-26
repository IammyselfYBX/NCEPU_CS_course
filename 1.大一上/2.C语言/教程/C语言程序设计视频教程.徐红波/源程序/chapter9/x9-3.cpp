#include "stdafx.h"

#include <math.h>

#define S(A, B, C) (A+B+C)/2

#define AREA(A, B, C) sqrt(S(A,B,C)*(S(A,B,C)-a)*(S(A,B,C)-b)*(S(A,B,C)-c))

int main(int argc, char* argv[])
{
	float a, b, c;
	a=3.0;
	b=4.0;
	c=5.0;

	printf("%f\n", AREA(a, b, c));
	

	return 0;
}