#include <stdio.h>
void main() 
{
	int i=5; 
	void converse(int n); 
	printf("Input 5 characters:"); 
	converse(i); 
	printf("\n"); 
} 
void converse(n); 
{
	char next; 
	if(n>=1) 
	{ 
		next=getchar(); 
		putchar(next); 
	} 
	else 
	{ 
		next=getchar(); 
		converse(n-1); 
		putchar(next); 
	} 
}
