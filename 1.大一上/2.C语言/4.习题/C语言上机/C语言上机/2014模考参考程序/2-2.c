#include<stdio.h>
#define N 80
void count(char str[],int a[])
{
	int i;
	for(i=0;str[i];i++)
	{
		
		if(str[i]>='A'&&str[i]<='Z'||str[i]>='a'&&str[i]<='z')
			a[0]++;
		else if(str[i]>='0'&&str[i]<='9')
			a[1]++;
		else
			a[2]++;
	}
}
void main()
{
	char str1[N];
	int a[3];
	gets(str1);
	a[0]=a[1]=a[2]=0;
	count(str1,a);
	printf("×ÖÄ¸%d,Êı×Ö%d,ÆäËû%d",a[0],a[1],a[2]);
}