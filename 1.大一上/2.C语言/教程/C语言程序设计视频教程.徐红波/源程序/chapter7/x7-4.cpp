#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a[20]={0,1,3,4,5,6,7,8,9,10};

	for(int i=0; i<20; i++)
		printf("%d ", a[i]);

	int x; //x=2
	scanf("%d", &x);

	for(i=0; i<=9; i++)
	{
		if(a[i] > x)
			break;
	}

	if(i<=9)
	{
		for(int j=9; j>=i; j--)
			a[j+1]=a[j];
		a[i]=x;
	}
	else
	{
		a[i]=x;
	}

	for(i=0; i<20; i++)
		printf("%d ", a[i]);












	return 0;
}