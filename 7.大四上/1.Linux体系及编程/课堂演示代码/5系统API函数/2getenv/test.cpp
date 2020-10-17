#include <iostream>
using namespace std;
#include <stdlib.h>


int main(int argc, char *argv[])
{
    printf("%s\n", getenv("SHELL"));
    printf("%s\n", getenv("LC_PAPER"));
    printf("%s\n", getenv("PATH"));
    printf("%s\n", getenv("PWD"));

    return 0;
}
