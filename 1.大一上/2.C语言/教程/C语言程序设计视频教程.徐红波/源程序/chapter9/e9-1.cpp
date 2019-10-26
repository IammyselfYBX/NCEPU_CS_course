#include "stdafx.h"

//#define PI 3.1415926
#define PI 3.1415926
#define ARRAY_SIZE 2000

int main(int argc, char* argv[])
{
	float r, l, v, s;
	printf("input radius:\n");
	scanf("%f", &r);

	int array[ARRAY_SIZE];
	//int array[2000;];

	l=2*PI*r;//l=2*3.14l5926*r;
	s=PI*r*r;//s=3.1415926*r*r;

	//#undef PI
	v=4.0/3.0*PI*r*r*r;//v=4.0/3.0*3.1415926*r*r*r;

	printf("l=%10.4f\ns=%10.4f\nv=%10.4f\n", l, s, v);

	return 0;
}