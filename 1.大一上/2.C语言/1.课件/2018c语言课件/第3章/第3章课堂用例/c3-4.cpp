#include <stdio.h> 
void main(void)
{
    int a, b;
    printf("input two numbers:     ");
    scanf("%d%d", &a, &b);
    if(a>b)
      printf("%d 是最大数\n", a);
    else
      printf("%d 是最大数\n", b);
}

