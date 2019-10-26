#include "stdafx.h"

#include <malloc.h>

char * mynew(int n)
{
	char * p;
	p=(char *)malloc(n);
	return p;
}

void myfree(char * p)
{
	free(p);
}

int main(int argc, char* argv[])
{
	char * head=mynew(20);

	for(int i=0; i<20; i++)
	{
		//head[i]='a'+i;
		*(head+i)='a'+i;
		printf("%c ", head[i]);
	}

	myfree(head);	
	
	return 0;
}