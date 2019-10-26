#include "stdafx.h"

int max(int, int);

void main()
{
	int a, b, c;
	scanf("%d %d", &a, &b);

	c=max(0, max(a, b));

	printf("c=%d\n", c);	
}

int max(int x, int y)
{
	int z;
	z =  x > y ? x: y;
	return z;

	/*if(x > y)
		return x;
	else
		return y;*/

	//return 3;

}


