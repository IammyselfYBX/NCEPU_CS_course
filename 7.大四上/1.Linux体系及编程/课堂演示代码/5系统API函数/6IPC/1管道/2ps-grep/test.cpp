#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
    int fd[2];
    pipe(fd);

    pid_t pid = fork();
    if (0 == pid) {//son
        close(fd[0]);
        //1。先重定向
        dup2(fd[1], 1);
        //execlp
        execlp("ps", "ps", "-aux", NULL);
    }else if (pid >0) { //father
        close(fd[1]);
        //1。先重定向
        dup2(fd[0], 0); //标准输入重定向
        execlp("grep", "grep", "bash", NULL);
    }

    return 0;
}


