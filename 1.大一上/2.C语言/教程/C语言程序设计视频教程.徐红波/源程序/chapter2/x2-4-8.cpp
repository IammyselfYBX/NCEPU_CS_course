#include <stdafx.h>

#include <math.h>

int main(int argc, char * argv[])
{
	float a, b, c;
	scanf("a=%f b=%f c=%f", &a, &b, &c);
	float disc;
	disc=b*b-4*a*c;
	if(disc > 0)
	{
		printf("x1=%f\n", (-b+sqrt(disc))/(2*a));
		printf("x2=%f\n", (-b-sqrt(disc))/(2*a));
	}
	if(disc == 0)
	{
		printf("x=%f", -b/(2*a));
	}
	if(disc < 0)
	{
		printf("方程没有实根");
	}

	return 0;

}