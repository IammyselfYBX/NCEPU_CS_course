#include "stdafx.h"

#include <math.h>

int main(int argc, char* argv[])
{
	int m, k, i;
	scanf("%d", &m);
	k=sqrt(m);
	i=2;
	while(i<=k)
	{
		if(m%i == 0)
		{
			break;
		}
		i=i+1;
	}
	if(i > k)
	{
		printf("%d是素数\n", m);
	}
	else
	{
		printf("%d不是素数\n", m);		
	}
	
	return 0;

}