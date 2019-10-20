#include  <stdio.h>
#include  <math.h>
void main(void)
{
	float x;
	x=1/3.0;
	if(fabs(x-1./3.0)<=1e-6) 
		printf("x 等于1/3\n");
	else
		printf("x不等于1/3\n");
}
