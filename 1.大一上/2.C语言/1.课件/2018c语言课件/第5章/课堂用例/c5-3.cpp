/*输入一串字符，以回车作为结束符，统计输入字符的个数*/
#include"stdio.h"
void main(void)
{
	char ch;
	int number = 0;
	printf("输入一串字符，以回车结束：");
	while((ch = getchar()) != '\n')  /*判断读入字符，如果不是回车，数量加1*/
		number++;
	printf("一共输入了%d个字符", number);
}
