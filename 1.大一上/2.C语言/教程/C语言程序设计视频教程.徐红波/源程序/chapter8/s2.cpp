#include "stdafx.h"

extern A;

static int power(int n)
{
	int y=1;
	for(int i=1; i<=n; i++)
		y=y*A;

	return y;
}



