#include <stdafx.h>

int main(int argc, char * argv[])
{
	int m, n;
	int min;
	scanf("%d %d", &m, &n);
	if(m<n)
	{
		min=m;
	}
	else
	{
		min=n;
	}
	for(int i=min; i>=1; i--)
	{
		if(m%i==0 && n%i==0)
		{
			printf("%d是%d和%d的最大公约数\n", i, m, n);
			break;
		}
	}

	return 0;
}