#include "stdafx.h"

#define PRICE 40

int main(int argc, char* argv[])
{
	int num, total;
	num=10;
	total=num*PRICE;
	printf("total=%d\n", total);

	PRICE=30;


	return 0;
}