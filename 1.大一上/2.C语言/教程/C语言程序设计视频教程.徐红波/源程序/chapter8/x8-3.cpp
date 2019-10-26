#include "stdafx.h"

#include <math.h>

int judge(int n);

void main()
{
	int n;
	scanf("%d", &n);
	if(judge(n) == 1)
		printf("is a prime\n");
	else
		printf("is not a prime\n");
}

int judge(int n)
{
	for(int i=2; i<=(int)sqrt(n); i++)
		if(n % i == 0)
			break;
	
	if(i > (int)sqrt(n))
		return 1;
	else
		return 0;
}