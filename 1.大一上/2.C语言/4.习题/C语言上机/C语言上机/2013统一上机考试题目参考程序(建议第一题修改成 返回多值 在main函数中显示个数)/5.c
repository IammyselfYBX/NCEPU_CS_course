//5.将字符串转换成整数再输出
#include"stdio.h"
main()
{
	int i,n=0;
	char str[10];
	gets(str);
	for(i=0;str[i];i++)
		n=n*10+(str[i]-'0');
	printf("%d\n",n);
}