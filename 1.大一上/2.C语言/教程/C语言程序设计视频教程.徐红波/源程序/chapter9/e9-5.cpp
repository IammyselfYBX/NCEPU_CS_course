#include "stdafx.h"

#define PR printf
#define NL "\n"
#define D "%d"
#define D1 D NL
#define D2 D D NL
#define D3 D D D NL
#define D4 D D D D NL
#define S "%s"

int main(int argc, char* argv[])
{
	int a, b, c, d;
	char string[]="CHINA";
	a=1; b=2; c=3; d=4;

	PR(D1, a);//printf("%d \n", a);
	PR(D2, a, b);//printf("%d%d \n", a, b);
	PR(D3, a, b, c);//printf("%d%d%d\n", a, b, c);
	PR(D4, a, b, c, d);//printf("%d%d%d%d \n", a, b, c, d);
	PR(S, string);
	


	return 0;
}