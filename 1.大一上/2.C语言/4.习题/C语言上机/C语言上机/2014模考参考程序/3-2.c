//2.用函数实现完成两个字符串的复制
#include"stdio.h"
void copy(char str1[],char str2[])
{
	int i;
	for(i=0;str1[i];i++)
		str2[i]=str1[i];
	str2[i]=0;
}
main()
{
	char str1[80],str2[80];
	gets(str1);
	copy(str1,str2);
	puts(str2);
}