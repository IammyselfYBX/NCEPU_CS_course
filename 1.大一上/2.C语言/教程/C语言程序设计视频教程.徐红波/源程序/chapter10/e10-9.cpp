#include "stdafx.h"

void sort(int x[], int n)
{
	for(int i=0; i<n-1; i++)
	{
		int p=i;
		for(int j=i+1; j<n; j++)
			if(x[j] < x[p])
				p=j;

		if(p != i)
		{
			int temp;
			temp=x[p];
			x[p]=x[i];
			x[i]=temp;
		}
	}
}

int main(int argc, char* argv[])
{
	int a[10];

	int * p=a;

	for(int i=0; i<10; i++)
		scanf("%d", p++);

	p=a;
	sort(p, 10);
	
	for(i=0; i<10; i++)
		printf("%d ", *(p+i));


	return 0;
}

