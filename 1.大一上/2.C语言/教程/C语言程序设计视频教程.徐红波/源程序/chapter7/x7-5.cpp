#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a[4]={8,6,5,4};

	int l;
	l=4;

	for(int i=0; i<=(l-1)/2; i++)
	{	
		int temp;
		temp=a[i];
		a[i]=a[l-1-i];
		a[l-1-i]=temp;
	}

	for(i=0; i<l; i++)
		printf("%d ", a[i]);
	printf("\n");

	return 0;
}