#include "stdafx.h"

#include <string.h>

void print(char * name[], int n);
void sort(char * name[], int n);

int main(int argc, char* argv[])
{
	char * name[5]={"Follow me", "BASIC", "Great Wall", "FORTRAN", "Computer design"};

	sort(name, 5);

	print(name, 5);

	return 0;
}

void print(char * name[], int n)
{
	for(int i=0; i<n; i++)
		printf("%s\n", name[i]);
}

void sort(char * name[], int n)
{
	for(int i=0; i<n-1; i++)
	{
		int p=i;
		for(int j=i+1; j<n; j++)
		{
			if(strcmp(name[j], name[p]) < 0)
			{
				p=j;
			}
		}
		if(p != i)
		{
			char * temp;
			temp=name[i];
			name[i]=name[p];
			name[p]=temp;
		}
	}
}