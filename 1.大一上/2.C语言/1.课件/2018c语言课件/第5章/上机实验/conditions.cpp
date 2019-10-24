#include <stdio.h>
void main()
{
	int a,b,c,d,e;
	a=1,b=2,c=3,d=4;
	e=a>b?a:c>d?c:d;
	printf("e:%d\n",e);
}
