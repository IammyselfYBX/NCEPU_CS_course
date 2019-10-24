#include <stdio.h>
#include <math.h>
void main(void)
{
    float a,b;
    char c;
    printf("输入表达式: 运算数<运算符>运算数\n");
    scanf("%f%c%f", &a, &c, &b);
    switch(c){
       case '+': printf("%f\n", a+b); break;
       case '-': printf("%f\n", a-b); break;
       case '*': printf("%f\n", a*b); break;
       case '/':
		   if(fabs(b)<=1e-6)
			   printf("数据错误，除数不能为0！\n");
		   else
			   printf("%f\n",a/b);
		   break;
       default: printf("运算符只能是+，-，*，/！\n");
    }
}
