#include "stdafx.h"

void sort(int a[], int n);

void main()
{
	int b[5]={3, 6, 1, 9, 4};

	sort(b, 5);

	for(int i=0; i<5; i++)
		printf("%d ", b[i]);	
}

void sort(int a[], int n)
{
	int p;
	for(int i=0; i<n-1; i++)
	{
		p=i;
		for(int j=i+1; j<n; j++)
		{
			if(a[j]<a[p])
				p=j;
		}
		int t;
		t=a[i];
		a[i]=a[p];
		a[p]=t;
	}
}