#include "stdafx.h"

#include "string.h"

void reverse(char c[], int n);

void main()
{
	char c[]={"hello world!"};

	printf("%s\n", c);

	reverse(c, strlen("hello world!"));

	printf("%s\n", c);
}

void reverse(char c[], int n)
{
	//hello
	char temp[200];

	int p=0;
	for(int i=n-1; i>=0; i--)
	{
		temp[p]=c[i];
		p++;
	}
	temp[p]='\0';

	for(i=0; i<n; i++)
		c[i]=temp[i];
}