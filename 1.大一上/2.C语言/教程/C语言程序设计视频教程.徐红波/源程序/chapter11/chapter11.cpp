// chapter11.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

/*#include <string.h>

struct date
{
	int month;
	int day;
	int year;
};

struct student {
	int num;
	char name[20];
	char sex;
	int age;
	float score;
	struct date birthday;
	char addr[30];
} s1, s2;*/

typedef int INTEGER;
#define INTEGER int;


typedef float REAL;

typedef struct date
{
	int month;
	int day;
	int year;
} DATE;

typedef int ARR[10];

typedef char * STRING;

typedef int (*POINTER)(int,float);


int main(int argc, char* argv[])
{
	INTEGER i, j;//int i, j;
	REAL a, b;//float a, b;
	DATE birthday;//struct date birthday;
	ARR arr;//int arr[10];
	for(i=0; i<=9; i++)
	{
		arr[i]=i;
		printf("%d ", arr[i]);
	}
	STRING p1, p2;//char * p1, p2;
	POINTER p3, p4;



	







	







	/*s1.num = 10010;
	strcpy(s1.name,"hello world!");
	s1.sex='m';
	s1.age=18;
	s1.score=87.5;
	strcpy(s1.addr,"Beijing");
	s1.birthday.month=2;
	s1.birthday.month+=2;
	s1.birthday.day=3;
	s1.birthday.year=1980;*/

	//printf("", s1);


	//printf("%x\n", &s1);
	//printf("%x\n", &s1.num);

	
	return 0;
}

