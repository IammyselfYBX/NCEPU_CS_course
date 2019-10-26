#include <stdafx.h>

void main()
{
	float term, sum;
	sum=0;
	term=1;
	for(int i=1; i<=20; i++)
	{
		term=term*i;
		printf("%d!=%f\n", i, term);
		sum+=term;
	}
	printf("sum=%f\n", sum);	
}