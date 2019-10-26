#include "stdafx.h"

int main(int argc, char* argv[])
{
	int sum, i;
	sum=0;
	i=1;
	while(i<=100)
	{
		sum=sum+i;
		i=i+1;
	}

	printf("1+2+...+100=%d\n", sum);	

	return 0;
}
