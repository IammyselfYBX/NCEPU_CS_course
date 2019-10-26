#include "stdafx.h"

int main(int argc, char* argv[])
{
	int sum;
	sum=0;	
	int i;
	i=1;
	do
	{
		sum=sum+i;
		i=i+1;
	}
	while(i<=100);

	printf("1+2+...+100=%d\n", sum);

	return 0;
}
