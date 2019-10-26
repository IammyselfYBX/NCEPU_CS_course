#include <stdafx.h>

main()
{
	float x=2.5;
	int a=7, b;
	float y=4.7;
	printf("%lf\n",x+a%3*(int)(x+y)%2/4);
	//2.5
	a=2;
	b=3;
	x=3.5;
	y=2.5;
	printf("%lf\n", (float)(a+b)/2+(int)x%(int)y);
	//3.5
}


