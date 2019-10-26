#include "stdafx.h"

#include <string.h>

int main(int argc, char* argv[])
{
	char diamond[5][5]={{' ', ' ', '*'},
						{' ', '*', ' ', '*'},
						{'*', ' ', ' ', ' ', '*'},
						{' ', '*', ' ', '*'},
						{' ', ' ', '*'}};

	for(int i=0; i<5; i++)
	{
		for(int j=0; j<5; j++)
		{
			printf("%c", diamond[i][j]);
		}
		printf("\n");
	}

	return 0;
}