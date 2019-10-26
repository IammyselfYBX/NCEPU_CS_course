#include "stdafx.h"

void copy_string(char * from, char * to);

int main(int argc, char* argv[])
{
	char a[]="I am a teacher.";
	char b[]="You are student.";

	printf("string a=%s string b=%s\n", a, b);

	printf("copy string a to string b:\n");

	char * from=a;
	char * to=b;
	copy_string(from, to);

	printf("string a=%s string b=%s\n", a, b);

	return 0;
}

void copy_string(char * from, char * to)
{
	while(*to++=*from++);
}