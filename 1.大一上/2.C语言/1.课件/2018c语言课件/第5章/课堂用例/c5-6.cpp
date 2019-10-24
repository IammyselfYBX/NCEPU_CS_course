/*ÊäÈëÒ»´®×Ö·û£¬½«ÆäÖÐµÄ×ÖÄ¸×Ö·û´óÐ¡Ð´»¥»»£¬Êä³ö»¥»»ºóµÄ×Ö·û´®¡£*/
#include "stdio.h"
void main(void)
{
	char ch;
	ch = getchar();
	while(ch != '\n')
	{
		if(ch >= 'a' && ch <= 'z')
			ch=ch-'a'+'A';
		else if(ch >= 'A' && ch <= 'Z')
			ch = ch - 'A' + 'a';
		putchar(ch);
		ch = getchar();
	}
}
