#include <stdafx.h>

void main()
{
	char c;
	scanf("%c", &c);
	//int d = c >= 'A' && c <= 'Z' ? c+32 : c;
	if(c >= 'A' && c <= 'Z')
		c+=32;
	printf("%c\n", c);
	
}