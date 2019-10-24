#include <stdio.h>
void main()
{
  int a=66;
  float b=122.1234567;
  double c=1234567890.1234567;
  printf("a=%d,%-5d,%5d,%5c\n", a, a, a, a);
  printf("b=%f,%lf,%5.4f,%.4e,%10.2f\n", b, b, b, b, b);
  printf("c=%lf,%f,%8.4lf\n", c, c, c);
 
 }
