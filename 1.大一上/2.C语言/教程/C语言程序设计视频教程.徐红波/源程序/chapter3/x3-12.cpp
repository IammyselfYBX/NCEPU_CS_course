#include <stdafx.h>

main()
{
	int a=12;
	printf("a+=a %d\n", a+=a);	//a=a+a
	printf("a-=2 %d\n", a-=2);	//a=a-2
	printf("a*=2+3 %d\n", a*=2+3);	//a=a*(2+3)=22*5
	printf("a/=a+a %d\n", a/=a+a);	//a=a/(a+a)
	int n=5;
	printf("a%=(n%=2) %d\n", a%=(n%=2));	//a=a%
	printf("a+=a-=a*=a %d\n", a+=a-=a*=a);
}

/*
1)a+=a	
	(2)a-=2
	(3)a*=2+3	
	(4)a/=a+a
	(5)a%=(n%=2), n的值等于5	
	(6)a+=a-=a*=a
*/