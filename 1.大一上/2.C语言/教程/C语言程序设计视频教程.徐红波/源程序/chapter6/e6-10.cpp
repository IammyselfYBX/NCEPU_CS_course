#include "stdafx.h"

int main(int argc, char* argv[])
{
	char c;
	while(( c=getchar() ) != '\n')
	{
		if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
		{
			if((c >= 'W' && c <= 'Z') || (c >= 'w' && c <= 'z'))
			{
				c=c-26;
			}
			c=c+4;
		}
		printf("%c", c);
	}
	printf("\n");
	
	return 0;
}