#include <stdafx.h>

int main(int argc, char * argv[])
{
	char a, b, c;
	int ia, ib, ic;
	a='B';
	b='O';
	c='Y';
	ia=putchar(a);
	putchar('\n');
	ib=putchar(b);
	putchar('\n');
	ic=putchar(c);
	putchar('\n');

	printf("ia=%c\n", ia);
	printf("ib=%c\n", ib);
	printf("ic=%c\n", ic);

	return 0;
	
}