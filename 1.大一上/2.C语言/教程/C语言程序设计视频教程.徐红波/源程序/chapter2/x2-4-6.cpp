#include <stdafx.h>

#include <math.h>

int judge(int n)
{
	int w;
	w=0;
	for(int i=2; i<=sqrt(n); i++)
	{
		int r;
		r=n%i;
		if(r==0)
		{
			w=1;
			break;
		}
	}
	return w;
}

int main(int argc, char * argv[])
{
	int n;
	for(n=100; n<=200; n++)
	{
		if(judge(n) == 0)
		{
			printf("%d是素数\n", n);
		}
		else
		{
			printf("%d不是素数\n", n);
		}
	}

	return 0;
}

