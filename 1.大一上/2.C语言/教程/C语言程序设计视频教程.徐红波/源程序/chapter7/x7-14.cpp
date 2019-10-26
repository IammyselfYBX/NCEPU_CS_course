#include "stdafx.h"

int main(int argc, char* argv[])
{
	char s1[]="DOG";
	char s2[]="cat";

	int flag=0;

	int i=0;
	while(s1[i]!='\0' || s2[i]!='\0')
	{
		if(s1[i]!=s2[i])
		{
			flag=1;
			printf("%c %c\n", s1[i], s2[i]);
			printf("%d\n", s1[i]-s2[i]);
			break;
		}
		else
		{
			i++;
		}
	}
	if(flag==0)
	{
		printf("0\n");
	}

	return 0;
}