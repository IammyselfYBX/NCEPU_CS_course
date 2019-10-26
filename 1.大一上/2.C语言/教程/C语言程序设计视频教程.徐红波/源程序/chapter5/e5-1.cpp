#include <stdafx.h>

void main()
{
	float x, y;
	scanf("%f %f", &x, &y);
	if(x > y)
	{
		float temp;
		temp=x;
		x=y;
		y=temp;
		//printf("%f %f\n", x, y);
	}	
	//else
	printf("%f %f\n", x, y);	
}