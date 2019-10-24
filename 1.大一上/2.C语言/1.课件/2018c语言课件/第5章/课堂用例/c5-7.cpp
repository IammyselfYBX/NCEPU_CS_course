/*输入一串字符，将字母字符大小写互换，输出互换后的字符串,用条件表达式实现。*/
#include "stdio.h"
void main(void)
{
	char ch;
	ch = getchar();
	while(ch != '\n')
	{
		ch=(ch>='a'&&ch<='z')?(ch-'a'+'A'):((ch>='A'&&ch<='Z')?(ch-'A'+'a'):ch);
		putchar(ch);
		ch = getchar();
	}
}
