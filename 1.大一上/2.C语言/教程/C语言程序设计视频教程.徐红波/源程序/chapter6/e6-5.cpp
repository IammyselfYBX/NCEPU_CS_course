#include "stdafx.h"

int main(int argc, char* argv[])
{
	for(int i=100; i<=200; i++)
	{
		if(i%3 == 0)
			continue;

		printf("%d\n", i);
	}
}