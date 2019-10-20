#include <stdio.h>
void fun (char s[])
{ int i,j;
    for (i=0,j=0; s[i]!='\0'; i++)
       if (s[i]>='0' && s[i]<='9')
          s[j++]=s[i];
    s[j]='\0';
}

void main()
{
	char data[] = "1f2g2g3f4f5g3g2f";
	fun(data);
	puts(data);
}