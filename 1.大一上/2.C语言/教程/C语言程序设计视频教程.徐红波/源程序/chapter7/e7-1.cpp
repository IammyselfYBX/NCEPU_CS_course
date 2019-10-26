#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a[10];

	for(int i=0; i<=10-1; i++)
		a[i]=i;

	for(i=9; i>=0; i--)
		printf("%d ", a[i]);
}