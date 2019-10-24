#include <stdio.h>
void main()
{
	char str[80];      /*声明一个字符数组str*/
	int i,m=0,n=0,k=0; /* m为字母的个数；n为数字的个数；k为其它字符的个数*/
	
	gets(str);
	
	for(i=0;str[i];i++)
		if(str[i]>='a'&&str[i]<='z'||str[i]>='A'&&str[i]<='Z')
			m++;
		else if(str[i]>='0'&&str[i]<='9')
			n++;
		else
			k++;
		
		printf("字母 %d 个；数字 %d 个；其它字符 %d 个\n",m,n,k);
}
