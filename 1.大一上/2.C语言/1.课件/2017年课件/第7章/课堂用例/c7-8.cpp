/*编写函数实现字符串的复制*/
#include "stdio.h"
#include "string.h"
#define N 80

void copy_string(char from[], char to[]);        /*函数声明*/
void main(void)
{
	char a[N], b[N];
	printf("请输入一串字符串：\n");
	gets(a);
	copy_string(a,b);                            /*函数调用*/
	puts(b);
}

void copy_string(char from[], char to[])         /*函数定义*/
{
  int i;

  for(i = 0;from[i] != '\0'; i++) /*当from数组元素不是'\0',复制到to数组*/
	  to[i] = from[i];
  to[i] = '\0';                   /*to数组最后添加'\0'，标识字符串结束*/
}
