#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a[6]={9, 8, 5, 4, 2, 0};

	for(int i=0; i<6-1; i++)
	{
		for(int j=0; j<6-i-1; j++)
		{
			if(a[j] > a[j+1])
			{
				int t;
				t=a[j];
				a[j]=a[j+1];
				a[j+1]=t;
			}
		}
	}

	for(int k=0; k<6; k++)
		printf("%d ", a[k]);

	printf("\n");

	return 0;
}