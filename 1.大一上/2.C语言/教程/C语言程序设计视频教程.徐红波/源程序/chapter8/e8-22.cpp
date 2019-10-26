#include "stdafx.h"

extern void enter_string(char str[80]);
extern void delete_string(char str[], char c);
extern void print_string(char str[]);

void main()
{
	char str[80];

	enter_string(str);

	char c;
	scanf("%c", &c);

	delete_string(str, c);

	print_string(str);
}