#include "stdafx.h"

void inv(int x[]/*int * x*/, int n)
{
	int i, j;
	for(i=0, j=n-1; i<=(n-1)/2; i++, j--)
	{
		int temp;
		temp=x[i];
		x[i]=x[j];
		x[j]=temp;
	}
}

int main(int argc, char* argv[])
{
	int a[10];

	for(int i=0; i<=9; i++)
		scanf("%d", &a[i]);

	int * p;

	p=a;
	//p=&a[0];

	inv(p, 10);
	//inv(a, 10);

	for(i=0; i<=9; i++)
		printf("%d,", a[i]);

	return 0;
}