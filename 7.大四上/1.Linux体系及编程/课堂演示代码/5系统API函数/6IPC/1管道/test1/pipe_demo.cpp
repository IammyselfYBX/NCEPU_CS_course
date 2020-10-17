
#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
    int fd[2];
    pipe(fd);

    pid_t pid = fork();

    if(0 ==  pid)
    {
        //son
        sleep(3);
        write(fd[1],"Hello\n", 6);
    }else if(pid>0)
    {
        //father
        char buf[50];
        //read会等待子进程输出
        int ret = read(fd[0], buf, sizeof(buf));
        if(ret >0)
        {
            write(STDOUT_FILENO, buf, ret);
        }
    }

    return 0;
}

