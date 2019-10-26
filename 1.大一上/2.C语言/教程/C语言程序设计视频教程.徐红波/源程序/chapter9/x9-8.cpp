#include "stdafx.h"

#define MAX(A,B,C) (A>B?A:B) > C ? (A>B?A:B) : C


int main(int argc, char* argv[])
{
	//int a=1, b=2, c=3;
	//float a=1.0, b=2.0, c=3.0;
	char a='a', b='b', c='c';

	printf("%c\n", MAX(a, b, c));
	

	return 0;
}