#include <stdio.h>
#include <string.h>
void main()
{
	int i,j;
	char s[80],result[80];
	printf("Enter a string:\n");
	gets(s);
	for(i=strlen(s)-1,j=0;i>=0;i--,j++)
	{
		result[j]=s[i];
	}
	printf("This is reverse string:\n");
	puts(result);
}
