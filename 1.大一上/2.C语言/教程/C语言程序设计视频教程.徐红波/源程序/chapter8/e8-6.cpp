#include "stdafx.h"

void a();
void b();

void main()
{
	a();
}

void a()
{
	printf("enter into function a()\n");
	b();
	printf("exit function a()\n");
}

void b()
{
	printf("enter into function b()\n");
	printf("exit function b()\n");
}