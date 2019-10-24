//2.用函数实现完成两个字符串的连接
#include"stdio.h"
void lian(char str1[],char str2[])
{
	int i=0,n;
	while(str1[i])
		i++;
	n=i;
	for(i=0;str2[i];i++)
		str1[n+i]=str2[i];
	str1[n+i]=0;
}
main()
{
	char str1[80],str2[80];
	gets(str1);
	gets(str2);
    lian(str1,str2);
	puts(str1);
}