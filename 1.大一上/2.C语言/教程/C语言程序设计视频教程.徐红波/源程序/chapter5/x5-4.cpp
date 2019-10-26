#include <stdafx.h>

void main()
{
	int a, b, c;
	scanf("%d %d %d", &a, &b, &c);
	int max=a;
	if(max < b)
	{
		int t;
		t=max;
		max=b;
		b=t;
	}
	if(max < c)
	{
		int t;
		t=max;
		max=c;
		c=t;
	}
	printf("max=%d\n", max);
}