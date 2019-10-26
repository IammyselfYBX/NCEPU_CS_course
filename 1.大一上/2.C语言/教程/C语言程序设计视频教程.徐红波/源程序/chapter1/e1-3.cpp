// chapter1.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"

int main(int argc, char* argv[])
{
	int x, y;
	scanf("%d %d", &x, &y);
	int max(int a, int b);
	int result=max(x, y);
	printf("max=%d\n", result);

	return 1;
}

int max(int a, int b)
{
	int temp;
	if (a > b) 
		temp=a;
	else
		temp=b;
	return temp;
}

