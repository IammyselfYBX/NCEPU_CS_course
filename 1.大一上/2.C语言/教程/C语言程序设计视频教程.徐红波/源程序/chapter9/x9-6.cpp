#include "stdafx.h"

#define F "%6.2f"
#define PR printf
#define NL "\n"
#define F1 F NL
#define F2 F F NL
#define F3 F F F NL


int main(int argc, char* argv[])
{
	float a=1.0, b=2.0, c=3.0;

	PR(F1, a);
	PR(F2, a, b);
	PR(F3, a, b, c);
		

	return 0;
}