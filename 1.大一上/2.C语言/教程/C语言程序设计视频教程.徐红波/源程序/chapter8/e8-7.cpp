#include "stdafx.h"

int age(int n);

void main()
{
	printf("%d\n", age(5));	
}

int age(int n)
{
	if(n == 1)
		return 10;
	else
		return age(n-1)+2;
}
