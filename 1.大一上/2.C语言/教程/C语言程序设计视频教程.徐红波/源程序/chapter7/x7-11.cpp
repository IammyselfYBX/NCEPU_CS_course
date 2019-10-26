#include "stdafx.h"

int main(int argc, char* argv[])
{
	char c[5][18]={	{"* * * * *"},
	{"  * * * * *"},
	{"    * * * * *"},
	{"      * * * * *"},
	{"        * * * * *"}};

	for(int i=0; i<5; i++)
		printf("%s\n", c[i]);

	return 0;
}