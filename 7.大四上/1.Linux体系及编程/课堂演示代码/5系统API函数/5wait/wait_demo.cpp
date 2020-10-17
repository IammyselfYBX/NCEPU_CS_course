#include <stdio.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <errno.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
    pid_t pid = fork();
    if (0 == pid) {
        printf("I am child, my pid=%d\n", getpid());
        sleep(2);
        while(1)
        {
            printf("I am become zombie\n");
            sleep(1);
        }
    }else if(pid > 0)
    {
        printf("I am father\n");
        int status;
        pid_t wpid = wait(&status);
        printf("wait finish, wpid= %d,pid=%d\n", wpid, pid);

        //使用2个宏来判断和回收子进程
        //子进程正常退出
        if (WIFEXITED(status)) {
            printf("child exit with %d\n", WIFEXITED(status));
        }

        //子进程被信号kill
        if(WIFSIGNALED(status)) {
            printf("child exit with %d\n", WTERMSIG(status));
        }

        while(1) {
            sleep(1);
        }
    }

    return 0;
}

