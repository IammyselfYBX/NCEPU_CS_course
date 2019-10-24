//6.100-200ÄÚËØÊıºÍ
#include"stdio.h"
#include"math.h"
main()
{
	int n,i,s=0;
	for(n=100;n<=200;n++)
	{
		for(i=2;i<=sqrt(n);i++)
			if(n%i==0)
				break;
		if(i>sqrt(n))
			s+=n;
	}
	printf("s=%d\n",s);
}