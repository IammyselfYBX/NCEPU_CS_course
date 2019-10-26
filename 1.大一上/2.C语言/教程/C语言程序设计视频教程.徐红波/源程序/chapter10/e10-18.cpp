#include "stdafx.h"

int main(int argc, char* argv[])
{
	char a[]="I am a boy.", b[20];
	char * p, * q;

	for(p=a, q=b; *p != '\0'; p++, q++)
		*q=*p;
	*q='\0';

	q=b;
	printf("%s\n", q);
	
	return 0;
}