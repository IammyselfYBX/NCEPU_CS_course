#include<stdio.h>
void main  ()
{
   int a,b,x;
   printf("*****   求两个数的最大公因数    *****\n\n\n");
   printf("        请输入两个数：");
   scanf ("%d%d",&a,&b);
   x=a;
   if(b<a) x=b;
   while (a%x!=0||b%x!=0)
     x--;
   printf("%d和%d的最大公因数是%d\n",a,b,x);
}