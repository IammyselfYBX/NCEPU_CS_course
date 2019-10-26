#include "stdafx.h"

int max(int x, int y);

extern A, B;

void main()
{
	printf("%d\n", max(A, B));	
}

int A=13, B=-8;

int max(int x, int y)
{
	int z;
	z = x > y ? x : y;
	return z;
}
