#include <stdio.h>
void main()
{
	char  c;
	int a;
	float x;
	a=12;
	c='a'+a;
	x=5346e-3;
	printf("c:%10c%10d\n",c,c);
	printf("a:%10d%10o%10x\n",a,a,a);
	printf("x:%10f%10.2f%10.2e\n",x,x,x);
}
