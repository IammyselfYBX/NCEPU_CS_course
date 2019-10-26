#include "stdafx.h"

void process(int a, int b, int (*p)(int,int));
int max(int a, int b);
int min(int a, int b);
int add(int a, int b);

int main(int argc, char* argv[])
{
	int a, b;
	scanf("%d %d", &a, &b);

	process(a, b, max);
	process(a, b, min);
	process(a, b, add);

	return 0;
}

void process(int a, int b, int (*p)(int,int))
{
	printf("%d\n", (*p)(a,b));
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
	if(a < b)
		return a;
	else
		return b;
}

int add(int a, int b)
{
	return a+b;
}