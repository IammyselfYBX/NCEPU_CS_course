#include "stdafx.h"

int main(int argc, char* argv[])
{
	int A;
	int B;
	A=1;
	B=2;
	printf("A=%d B=%d\n", A, B);
	int C;
	C=A;
	A=B;
	B=C;
	printf("A=%d B=%d\n", A, B);

	return 0;
}