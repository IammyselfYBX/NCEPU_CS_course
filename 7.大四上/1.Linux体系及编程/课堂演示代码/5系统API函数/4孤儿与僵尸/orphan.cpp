#include <iostream>
using namespace std;

#include <unistd.h>

int main(int argc, char *argv[])
{
    pid_t pid = fork();

    if(0 == pid)
    {
        while(1)
        {
            cout<<"I am child ,pid = "<<getpid()<<"ppid="<<getppid()<<endl;
            sleep(1);
        }
    }else if(pid > 0) {
        printf("I am father, pid= %d, ppid = %d", getpid(), getppid());
        sleep(1);
        printf("I am father, I will die!!!");
    }

    return 0;
}

