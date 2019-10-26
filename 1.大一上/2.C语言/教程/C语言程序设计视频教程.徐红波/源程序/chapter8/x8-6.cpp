#include "stdafx.h"

void myconnect(char str1[], char str2[]);

char str3[200];

void main()
{
	char str1[]="hello ";
	char str2[]="world!";

	//char * pStr3;

	myconnect(str1, str2);

	printf("%s\n", str3);
}

void myconnect(char str1[], char str2[])
{
	int i=0;
	int p=0;
	while(str1[i] != '\0')
		str3[p++]=str1[i++];

	i=0;
	while(str2[i] != '\0')
		str3[p++]=str2[i++];

	str3[p]='\0';
	//return str3;
}
