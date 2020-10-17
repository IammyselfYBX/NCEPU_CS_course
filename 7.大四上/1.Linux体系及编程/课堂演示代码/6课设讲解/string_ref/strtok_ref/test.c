#include <stdio.h>
#include<string.h>
int main()
{
  char str[] = "mv a.c b.c";
  char *p;
  char *buff;
  buff=str;
  p = strsep(&buff, " ");
  while(p!=NULL)
  {
    printf("%s\n", p);
    p = strsep(&buff, " ");
  }
  return 0;
}
