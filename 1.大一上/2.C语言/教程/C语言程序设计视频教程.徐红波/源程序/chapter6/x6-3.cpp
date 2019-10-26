#include <stdafx.h>

void main()
{
	int a, n, term, sum;
	term=0;
	scanf("%d %d", &a, &n);
	sum=0;
	for(int i=1; i<=n; i++)
	{
		term=term*10+a;
		printf("%d->%d\n", i, term);
		sum=sum+term;
	}
	printf("sum=%d\n", sum);
	
}