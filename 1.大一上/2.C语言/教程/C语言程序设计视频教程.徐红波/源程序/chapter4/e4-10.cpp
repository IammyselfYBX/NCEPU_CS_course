#include <stdafx.h>

#include <math.h>

void main()
{
	float a, b, c;
	scanf("%f,%f,%f", &a, &b, &c);
	double s;
	s=(a+b+c)/2;
	double area;
	area=sqrt(s*(s-a)*(s-b)*(s-c));
	printf("area=%.2lf\n", area);	
}