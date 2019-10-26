#include <stdafx.h>
	
void main()
{
	int i, j, m, n;
	i=8;
	j=10;
	m=++i;	//m=9 i=9
	n=j++;	//n=10 j=11
	printf("%d, %d, %d, %d\n", i, j, m, n);
}
