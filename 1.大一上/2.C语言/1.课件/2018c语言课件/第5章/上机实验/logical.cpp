#include  "stdio.h"
void main()
{
	int a=0,b;
	b=a++&&a++&&a++;
	printf("%d.%d",a,b);
	a=0;
b=a++&&a++||a++;
	printf("%d.%d",a,b);
}
