#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
    pid_t pid = fork();
    if (0 == pid) {
        printf("I am child, My pid = %d, ppid = %d\n", getpid(), getppid());
        sleep(1);
        printf("I am child, I will die!!!!\n");
    }else if (pid >0)
    {
        while(1)
        {
            printf("I am father, My pid = %d, My ppid = %d\n", getpid(), getppid());
            sleep(1);
        }
    }

    return 0;
}
