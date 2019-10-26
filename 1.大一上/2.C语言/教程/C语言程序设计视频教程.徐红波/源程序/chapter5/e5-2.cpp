#include <stdafx.h>

void main()
{
	float a, b, c, t;
	scanf("%f %f %f", &a, &b, &c);
	if(a > b)
	{
		t=a;
		a=b;
		b=t;
	}
	if(a > c)
	{
		t=a;
		a=c;
		c=t;
	}
	if(b > c)
	{
		t=b;
		b=c;
		c=t;
	}
	printf("%f %f %f\n", a, b, c);
}