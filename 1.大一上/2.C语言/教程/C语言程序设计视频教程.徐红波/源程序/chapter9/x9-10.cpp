#include "stdafx.h"

#define CHANGE 1

int main(int argc, char* argv[])
{
	char str[]={"z hello world!"};

	for(int i=0; str[i] != '\0'; i++)
	{
		#if CHANGE
			if(str[i] >= 'a' && str[i] <= 'z' || str[i] >= 'A' && str[i] <= 'Z')
			{
				if(str[i] == 'z' || str[i] == 'Z')
					str[i]-=25;
				else
					str[i]++;
			}
		#endif
		printf("%c", str[i]);
		
	}
	printf("\n");

	return 0;
}