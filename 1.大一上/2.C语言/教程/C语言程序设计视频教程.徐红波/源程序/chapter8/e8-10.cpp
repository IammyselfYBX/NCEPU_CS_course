#include "stdafx.h"

int large(int x, int y);

void main()
{
	int a[10], b[10];
	int c1=0, c2=0, c3=0;

	for(int i=0; i<10; i++)
		scanf("%d", &a[i]);

	for(i=0; i<10; i++)
		scanf("%d", &b[i]);

	for(i=0; i<10; i++)
	{
		/*if(a[i] > b[i])
			c1++;
		if(a[i] == b[i])
			c2++;
		if(a[i] < b[i])
			c3++;*/
		int result=large(a[i], b[i]);
		if(result == 1)
		{
			c1++;
		}
		else if(result == -1)
		{
			c3++;
		}
		else
		{
			c2++;
		}
	}

	printf("c1=%d c2=%d c3=%d\n", c1, c2, c3);

	if(c1 < c3)
		printf("array b > array a\n");

	if(c1 > c3)
		printf("array a > array b\n");

	if(c1 == c3)
		printf("array a == array b\n");
}

int large(int x, int y)
{
	if(x > y)
		return 1;
	else
		if(x < y)
			return -1;
		else
			return 0;
}