#include "stdafx.h"

int f(int a);

void main()
{
	int a=2, i;

	f(1);

	//for(i=0; i<3; i++)
	//	printf("%d ", f(a));

	//printf("c=%d\n", c);
}

int f(int a)
{
	auto int b;
	static int c=0;
	b=b+1;
	c=c+1;
	printf("b=%d c=%d\n", b, c);
	return (a+b+c);
}
