#include <stdio.h>
#include <stdlib.h>

#define BUF_SIZE 1024

int main(int argc, char *argv[])
{
    char buf[BUF_SIZE];
    FILE *p_f = popen("ifconfig", "r");
    if(!p_f)
    {
        fprintf(stderr, "Erro to popen");
        //The popen() function does not set errno if memory allocation fails. 
    }

    while(fgets(buf, BUF_SIZE, p_f)!= NULL)
    {
        fprintf(stdout, "%s", buf);
    }
    pclose(p_f);

    return 0;
}

