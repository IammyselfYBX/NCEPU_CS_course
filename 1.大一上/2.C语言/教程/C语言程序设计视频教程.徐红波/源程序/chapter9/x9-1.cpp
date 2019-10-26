#include "stdafx.h"

#define SWAP(A, B) int T;T=A;A=B;B=T;

int main(int argc, char* argv[])
{
	int a=1, b=2;

	printf("a=%d b=%d\n", a, b);

	SWAP(a, b);//int T;T=a;a=b;b=T;

	printf("a=%d b=%d\n", a, b);
	

	return 0;
}