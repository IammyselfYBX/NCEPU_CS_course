#include "stdafx.h"

int main(int argc, char* argv[])
{	
	int a;
	int max;

	scanf("%d", &a);
	max=a;
	
	for(int i=2; i<=10; i++)
	{
		scanf("%d", &a);
		if(a > max)
		{
			max=a;
		}
	}

	printf("max=%d\n", max);


	return 0;
}