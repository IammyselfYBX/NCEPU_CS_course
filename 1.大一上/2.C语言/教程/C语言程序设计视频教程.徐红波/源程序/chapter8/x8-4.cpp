#include "stdafx.h"

void transform(int a[3][3]);
void print_array(int a[3][3]);

void main()
{
	int a[3][3]={{0,1,2},{3,4,5},{6,7,8}};

	printf("before:\n");

	print_array(a);

	transform(a);

	printf("after:\n");

	print_array(a);
}

void print_array(int a[3][3])
{
	for(int i=0; i<3; i++)
	{
		for(int j=0; j<3; j++)
			printf("%d ", a[i][j]);
		printf("\n");
	}
}

void transform(int a[3][3])
{
	for(int i=0; i<3; i++)
		for(int j=0; j<=i; j++)
		{
			//a[j][i]<->a[i][j]
			int temp;
			temp=a[j][i];
			a[j][i]=a[i][j];
			a[i][j]=temp;
		}
}