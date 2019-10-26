#include "stdafx.h"

#include <string.h>

int main(int argc, char* argv[])
{
	int counter=0;

	char c[100];
	gets(c);

	for(int i=0; c[i]!='\0'; i++)
		if(c[i]==' ')
			counter++;

	printf("%d\n", counter+1);	

	return 0;
}
