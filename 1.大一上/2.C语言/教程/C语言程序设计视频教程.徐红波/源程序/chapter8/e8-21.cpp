#include "stdafx.h"

int A;

int power(int n);

void main()
{
	int b=3, c, d, m;
	printf("enter the number a and its power m:\n");
	scanf("%d,%d", &A, &m);
	c=A*b;
	printf("%d*%d=%d\n", A, b, c);

	d=power(m);
	printf("%d**%d=%d\n", A, m, d);

}

static int power(int n)
{
	return n;
}
