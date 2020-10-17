#include <unistd.h>
#include <stdio.h>
#include <sys/stat.h>
#include <fcntl.h>

int main(int argc, char *argv[])
{
    //先备份现场 1，要不就找不回来了
    int outfd = dup(1);
    //重定向到文件
    int fd = open("text.txt",O_WRONLY|O_CREAT, 0666);
    dup2(fd, 1);//1是标准输入
    printf("YBX is the most handsome man in NCEPU\n");

    //需要刷新，强制写入文件
    fflush(stdout);
    //恢复1,这次输出到显示器
    dup2(outfd, 1);
    printf("YBX is the most briliant man in NCEPU\n");

    close(fd);

    return 0;
}

