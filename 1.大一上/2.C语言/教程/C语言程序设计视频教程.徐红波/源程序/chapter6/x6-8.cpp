#include <stdafx.h>

void main()
{
	int fenzi, fenmu;
	float sum;
	sum=0;
	fenzi=2;
	fenmu=1;

	for(int i=1; i<=20; i++)
	{
		printf("%d->%d/%d\n", i, fenzi, fenmu);
		sum=sum+(float)fenzi/fenmu;
		int temp=fenzi;
		fenzi=fenzi+fenmu;
		fenmu=temp;
	}
	printf("%f\n", sum);

	
}