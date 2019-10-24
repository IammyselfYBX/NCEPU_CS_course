#include  "stdio.h"
long func(long s);
void main()
{
	long a;
	a = 123456789;
	printf("%ld",func(a));
}
long func(long s)
{ 
	long t , sl=1;
	int d ;
	t = 0 ;
	while ( s > 0 )
	{
		d = s%10;
		if (d%2==0) 
		{
			t=d* sl+ t;
			sl *= 10;
		}
		s/=10;
	}
	return (t);
}