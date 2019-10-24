#include <stdio.h>
void main()
{
	char c;
    c=getchar();   /* getchar()函数的功能为在键盘上输入一个字符赋给变量c */
    c=c-32;        /* 将c存储的字符的ASCII码减去32 */    
    putchar(c);    /* putchar(c)函数的功能为输出变量c中存储的字符 */ 
	putchar('\n');
 }

