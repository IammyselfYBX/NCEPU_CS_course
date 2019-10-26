#include "stdafx.h"

//#define S(a, b) a*b

#define PI 3.1415926
#define S(r) PI*(r)*(r)

int main(int argc, char* argv[])
{
	/*int area;

	area=S(3, 2);//area=3*2;

	printf("area=%d\n", area);*/

	float a, b, area;
	a=3.6;
	b=2.4;
	area=S(a+b);//area=(r) PI*(r)*(r)(a+b);

	printf("r=%f\narea=%f\n", a, area);






	return 0;
}