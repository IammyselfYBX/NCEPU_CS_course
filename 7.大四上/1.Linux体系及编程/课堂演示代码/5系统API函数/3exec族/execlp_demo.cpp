#include <iostream>
using namespace std;

#include <unistd.h>
#include <errno.h>

int main(int argc, char *argv[])
{
    if(-1 == execlp("ls", "ls", "-la", NULL))
    {
        perror("execlp error");
    }

    return 0;
}


