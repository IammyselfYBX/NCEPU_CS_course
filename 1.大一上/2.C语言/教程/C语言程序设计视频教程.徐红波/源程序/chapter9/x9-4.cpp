#include "stdafx.h"

#define LEAP_YEAR(Y) ((Y%4==0 && Y%100!=0) || Y%400==0)

int main(int argc, char* argv[])
{
	int year=1980+1;
	if(LEAP_YEAR(year))
		//
		printf("%d is a leap year.\n", year);
	else
		printf("%d is not a leap year.\n", year);


	return 0;
}