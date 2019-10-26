#include "stdafx.h"

int main(int argc, char* argv[])
{
	char str1[]="hello";
	char str2[]=" world!";

	char str3[100];

	int i, j, k;

	i=0;
	k=0;

	while(str1[i] != '\0')
	{
		str3[k]=str1[i];
		i++;
		k++;
	}

	i=0;
	while(str2[i] != '\0')
	{
		str3[k]=str2[i];
		i++;
		k++;
	}

	str3[k]='\0';

	printf("%s\n", str3);

	return 0;
}