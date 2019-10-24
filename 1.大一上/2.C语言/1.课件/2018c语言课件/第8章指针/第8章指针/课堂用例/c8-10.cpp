#include <stdio.h>
#include <stdlib.h>

#define MAXLEN 300        /*符号常量MAXLEN，代表一行的字符数 */

void main()
{
	char str2[MAXLEN];
	char *str;
	int flag;

	int pal(char *);
	void trim(char *, char *);
                         /* 动态申请内存空间*/
	if ((str = (char *) malloc(MAXLEN)) == NULL) {
		printf("内存分配错误!\n");
		exit(0);
	}
	
	printf("请输入一个句子:\n");
	gets(str);
	while (*str != '#') {
		trim(str, str2);
		flag = pal(str2);
		printf("\"%s\" ",str);
		if (flag) 
			puts("是一个回文句!");
		else 
			puts("不是一个回文句!");
		printf("请输入一个句子:\n");
		gets(str);
	}
	free(str);
}
      /*判断是否为回文单词*/
int pal(char *str)
{
	char *p, *q;

	p = str; q = str;    /* p指向字符串的首部*/
	while (*q != '\0') 
		q++;             /* q指向字符串的尾部*/
	q--;
	while (p < q) 
		if (*p == *q) {
			p++; q--;
		} else break;
	return (p >= q);
}
     /* 去掉句子中的其它符号 */
void trim(char * str1, char * str2)
{
	while (*str1 !='\0') {
		if (*str1 >= 'a' && *str1 <= 'z') {
			*str2 = *str1;
			str2++;
		}
		str1++;
	}
	*str2='\0';
}
