#include "stdafx.h"

#include <math.h>

int main(int argc, char* argv[])
{
	int n, s;
	float t, pi;
	t=1.0;
	pi=0;
	n=1;
	s=1;
	while(fabs(t)>=1e-6)
	{
		pi=pi+t;
		n=n+2;
		s=-1*s;
		t=(float)s*1/n;
	}
	printf("%f\n", pi*4);	

	return 0;

}