#include <iostream>
using namespace std;
#include <unistd.h>
#include <errno.h>


int main(int argc, char *argv[])
{
    if(-1 == execl("/bin/ls", "YBX", "-l", NULL))
    {
        perror("execl error");
    }
    

    return 0;
}
