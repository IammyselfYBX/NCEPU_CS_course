#include <stdafx.h>

void main()
{
	char c;
	int c1, c2, c3, c4;
	c1=c2=c3=c4=0;
	while((c=getchar()) != '\n')
	{
		if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
			c1++;
		else if(c == ' ')
				c2++;
		else if(c >= '0' && c <= '9')
				c3++;
		else c4++;
	}
	printf("%d %d %d %d\n", c1, c2, c3, c4);
	
}