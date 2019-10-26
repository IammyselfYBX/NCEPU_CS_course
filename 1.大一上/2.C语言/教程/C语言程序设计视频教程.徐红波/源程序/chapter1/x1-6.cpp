// chapter1.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

int max(int a, int b, int c)
{
	int temp;
	temp=a;
	if(temp < b)
		temp=b;
	if(temp < c)
		temp=c;
	return temp;
}

int main(int argc, char* argv[])
{
	int a, b, c;
	
	scanf("%d %d %d", &a, &b, &c);
	printf("max=%d\n", max(a, b, c));

	return 0;
}

