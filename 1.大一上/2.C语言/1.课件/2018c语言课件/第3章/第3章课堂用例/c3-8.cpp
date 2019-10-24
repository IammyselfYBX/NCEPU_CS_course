#include"stdio.h"
void main(void)
{
    char c;
    printf("请输入一个字符:    ");
    c=getchar();
    if(c>='0'&&c<='9')
      printf("是数字\n");
    else if(c>='A'&&c<='Z')
      printf("是大写字母\n");
    else if(c>='a'&&c<='z')
      printf("是小写字母\n");
    else
      printf("是其他字符\n");
	}
