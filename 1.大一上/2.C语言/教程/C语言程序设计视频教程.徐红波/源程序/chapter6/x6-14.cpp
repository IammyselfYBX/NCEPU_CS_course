#include <stdafx.h>

#include <math.h>

void main()
{
	for(int i=-3; i<=3; i++)
	{
		for(int j=1; j<=2*abs(i); j++)
			printf(" ");
		for(int k=1; k<=2*(3-abs(i))+1; k++)
			printf("* ");
		printf("\n");
	}
	
}