#include "stdafx.h"

#define PI 3.1415926
#define CIRCLE(R,L,S,V) L=2*PI*R;S=PI*R*R;V=4.0/3.0*PI*R*R*R

int main(int argc, char* argv[])
{

	float r, l, s, v;
	scanf("%f", &r);

	CIRCLE(r,l,s,v);
	//l=2*3.1415926*r;s=3.1415926*r*r;v=4.0/3.0*3.1415926*r*r*r
	
	printf("r=%6.2f,l=%6.2f,s=%6.2f,v=%6.2f\n", r, l, s, v);

	return 0;
}