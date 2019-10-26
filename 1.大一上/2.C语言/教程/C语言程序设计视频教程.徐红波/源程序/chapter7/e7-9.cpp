#include "stdafx.h"

#include <string.h>

int main(int argc, char* argv[])
{
	char str[3][20];

	char max[20];

	for(int i=0; i<=2; i++)
		gets(str[i]);

	if(strcmp(str[0], str[1]) > 0)
		strcpy(max, str[0]);
	else
		strcpy(max, str[1]);

	if(strcmp(max, str[2]) < 0)
		strcpy(max, str[2]);

	printf("%s\n", max);

	return 0;
}