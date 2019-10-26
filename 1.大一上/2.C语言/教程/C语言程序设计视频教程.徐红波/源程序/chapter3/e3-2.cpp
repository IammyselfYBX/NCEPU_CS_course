#include "stdafx.h"

int main(int argc, char* argv[])
{
	signed int a, b, c, d;
	unsigned int u;
	a=12;
	b=-24;
	u=10;
	c=a+u;
	d=b+u;
	printf("a+u=%d, b+u=%d\n", c, d);

	return 0;

}