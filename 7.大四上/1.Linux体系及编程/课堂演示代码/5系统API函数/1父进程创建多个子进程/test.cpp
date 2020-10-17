#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <errno.h>
#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
    int n =5;
    pid_t pid = 0;
    for (int i = 0; i < 5; i++) {
        pid = fork();
        if (pid <0) {
            perror("fork error");
            exit(EXIT_FAILURE);
        }else if(pid == 0)
        {
            n++;
            cout<<endl;
            cout<<endl;
            printf("my n = %d", n);
            printf("I am child, My PID is %d, My father pid is %d\n", getpid(), getppid());
            break;
        }else
        {
            n++;
            cout<<endl;
            cout<<endl;
            printf("my n = %d", n);
            printf("I am father , My PID is %d\n", getpid());
            sleep(2);
        }
    }

    return 0;
}
