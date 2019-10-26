// chapter10.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include <malloc.h>


int main(int argc, char* argv[])
{
	char * string;

	string=NULL;

   /* Allocate space */
   string = (char *)malloc(5);
   if( string == NULL )
      printf( "Insufficient memory available\n" );
   else
   {
		*(string+0)='a';
		*(string+1)='b';
		*(string+2)='c';
 		*(string+3)='d'; 
		*(string+4)='\0';

		printf("%s\n", string);

		free( string );
		printf( "Memory freed\n" );
   }



	//printf("%x\n", p);

	/*for(int i=0; i<argc; i++)
		printf("%s\n", argv[i]);

	getchar();*/

	//int i, j;
	//int * i_pointer, * j_pointer;

	//i_pointer=&i;
	//j_pointer=&j;

	//printf("%d\n", sizeof(i_pointer));
	//printf("i=%d\n", i);
	//printf("i=%d\n", *i_pointer);//*i_pointer==i
	//printf("j=%d\n", *j_pointer);//*j_pointer==j


	/*scanf("%d", &i);
	scanf("%d", &j);

	printf("%d\n", i);
	printf("%d\n", j);

	int k;
	k=i+j;

	printf("%d\n", k);

	printf("%x\n", &i);
	printf("%x\n", &j);*/

	/*int i;
	int * i_pointer;

	i=1;

	i_pointer=&i;

	printf("i=%d\n", i);
	printf("*i_pointer=%d\n", *i_pointer);*/

	/*int i;
	int * pointer_1;

	pointer_1=&i;

	printf("%x\n", pointer_1);
	printf("%x\n", pointer_1+1);*/

	/*char c;
	c='a';
	char * c_pointer;
	c_pointer=&c;

	printf("%x\n", c_pointer);
	printf("%x\n", c_pointer+1);*/

	/*int a=1;
	int * pointer_1=&a;

	printf("&a=%x\n", &*pointer_1);

	printf("a=%d\n", *&a);

	printf("a++=%d\n", (*pointer_1)++);*/

	/*int a[10]={0,1,2,3,4,5,6,7,8,9};

	//int * p;
	//p=a;
	//p=&a[10];
	printf("&a[10]-&a[9]=%d\n", &a[10]-&a[9]);
	printf("&a[9]-&a[7]=%d\n", &a[9]-&a[7]);*/

	/*int a[10]={0,1,2,3,4,5,6,7,8,9};

	int * p;

	for(p=a; p<a+10; p++)
	{
		printf("%d ", *p);
	}
	printf("\n");

	p=a;
	for(int i=0; i<10; i++)
	{
		//printf("%d ", *(a+i));
		printf("%d ", *(p+i));
	}
	printf("\n");*/


	


	return 0;
}

