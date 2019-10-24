//1. 求100-200内素数和
#include"stdio.h"
#include"math.h"
main()
{
	int s=0,n,i;
	for(n=100;n<=200;n++)
	{
		for(i=2;i<=sqrt(n);i++)
			if(n%i==0)
				break;
		if(i<=sqrt(n))
			s+=n;
	}
	printf("%d\n",s);
}