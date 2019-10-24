//1. 完成两个字符串的连接
#include"stdio.h"
main()
{
	char str1[80],str2[80];
	int i=0,n;
	gets(str1);
	gets(str2);
	while(str1[i])
		i++;
	n=i;
	for(i=0;str2[i];i++)
		str1[n+i]=str2[i];
	str1[n+i]=0;
	puts(str1);
}