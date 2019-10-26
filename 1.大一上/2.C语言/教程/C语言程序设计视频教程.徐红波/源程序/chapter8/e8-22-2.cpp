#include "stdafx.h"

extern void delete_string(char str[], char c)
{
	//hello\0
	//l
	int i;
	int p;
	for(i=0, p=0; str[i] != '\0'; i++)
	{
		if(str[i]==c)
		{
		}
		else
		{
			str[p]=str[i];
			p++;
		}
	}
	str[p]='\0';
}