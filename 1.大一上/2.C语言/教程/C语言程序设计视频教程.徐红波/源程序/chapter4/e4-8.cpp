#include <stdafx.h>

main()
{
	printf("12345678901234567890\n");

	float f=123.456;
	printf("%f\n", f);
	printf("%10f\n", f);
	printf("%10.2f\n", f);
	printf("%.2f|\n", f);
	printf("%-10.2f|\n", f);


	return 0;
}