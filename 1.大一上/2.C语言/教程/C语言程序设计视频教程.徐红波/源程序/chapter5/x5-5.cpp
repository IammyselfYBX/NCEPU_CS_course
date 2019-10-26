#include <stdafx.h>

void main()
{
	float x, y;
	scanf("%f", &x);
	if(x < 1)
	{
		y=x;
	}
	else
	{
		if(x < 10)
		{
			y=3*x-11;
		}
		else
		{
			y=2*x-1;
		}
	}
	printf("y=%f\n", y);
}