//3.×Ö·û´®ÄæĞòÊä³ö
#include"stdio.h"
main()
{
	char str1[80],str2[80];
	int i=0,n=0;
	gets(str1);
	while(str1[i])
		i++;
	n=i-1;
	for(i=0;i<=n;i++)
		str2[i]=str1[n-i];
	str2[i]='\0';
	puts(str2);
}