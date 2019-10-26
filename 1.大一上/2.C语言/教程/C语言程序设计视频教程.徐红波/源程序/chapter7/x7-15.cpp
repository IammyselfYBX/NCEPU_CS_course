#include "stdafx.h"

int main(int argc, char* argv[])
{
	char s1[100];
	char s2[]="hello world!";

	int i=0;
	while(s2[i] != '\0')
	{
		s1[i]=s2[i];
		i++;
	}
	s1[i]='\0';

	printf("%s\n", s1);

	return 0;
}