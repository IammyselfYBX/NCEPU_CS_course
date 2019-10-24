#include"stdio.h"
main()
{
	int i;
	char str1[80],str2[80];
	gets(str1);
	for(i=0;str1[i];i++)
	str2[i]=str1[i];
	str2[i]=0;
	puts(str2);
}