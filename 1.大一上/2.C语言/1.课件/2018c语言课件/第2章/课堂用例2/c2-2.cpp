#include <stdio.h> 
void main()
{
	char c;    /* 声明字符型变量c */
    int x;     /* 声明整型变量x */
    c=97;      /* 97是a的ASCII码 */
    x='b';     
    printf("%c,%d\n", c, c);   
    printf("%d,%c\n", x, x); 
}

