/*¶Á³ÌÐò£¬Ð´½á¹û*/
#include "stdio.h"
int a = 0, b;
void sub();

void main(void)
{  
	printf ("main:a=%d, b=%d\n", a, b);
    a = 3;
    b = 4;
    printf ("main:a=%d, b=%d\n", a, b); 
    sub();
    printf ("main:a=%d, b=%d\n", a, b);
}

void sub()
{  
	int a;
    a=6;    
	b=7;
    printf ("sub:a=%d, b=%d\n", a, b);
}
