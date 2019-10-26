#include "stdafx.h"

#define LETTER 0//a -> A
//#define LETTER 0//A -> a

int main(int argc, char* argv[])
{
	char str[20]="C Language";

	for(int i=0; str[i] != '\0'; i++)
	{
		#if	LETTER
			if(str[i] >= 'a' && str[i] <= 'z')
				str[i]-=32;
		#else
			if(str[i] >= 'A' && str[i] <= 'Z')
				str[i]+=32;
		#endif
		printf("%c", str[i]);
	}
	printf("\n");

	return 0;
}