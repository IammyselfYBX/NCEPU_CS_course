#include <stdio.h>
#include <stdlib.h>
	
#define MAXLEN 80   /*符号常量MAXLEN，代表一行的字符数 */

void main()
{
	char *str;
	int flag;

	int pal(char *);
                    /* 动态申请内存空间*/
	if ((str = (char *) malloc(MAXLEN)) == NULL) {
		printf("Memory allocation error!\n");
		exit(0);
	}
	
	printf("Input a word:\n");
	scanf("%s", str);
	while (*str != '#') {
		flag=pal(str);
		if (flag)
			printf("%s is a palindrome!\n", str);
		else 
            printf("%s isn't a palindrome!\n", str);
		printf("Input a word:\n");
		scanf("%s",str);
	}
	free(str);
}
    /*判断是否为回文单词*/
int pal(char *str)
{
	char *p, *q;

	p = str; q = str;         /* p指向字符串的首部*/
	while (*q != '\0') 
		q++;             /* q指向字符串的尾部*/
	q--;
	while (p < q) 
		if (*p == *q) 
		{
			p++; q--;
		} 
		else break;
	return (p >= q);
}
