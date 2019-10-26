#include "stdafx.h"

int max(int a, int b);

int main(int argc, char* argv[])
{
	int a, b;
	scanf("%d %d", &a, &b);

	int (*p)(int,int);

	p=max;
	//p++;
	//p=min;
	//p=printf;

	//printf("max=%d\n", max(a, b));
	printf("max=%d\n", (*p)(a, b));

	return 0;
}

int max(int a, int b)
{
	if(a > b)
		return a;
	else
		return b;
}

int min(int a, int b)
{
	if(a > b)
		return b;
	else
		return a;
}