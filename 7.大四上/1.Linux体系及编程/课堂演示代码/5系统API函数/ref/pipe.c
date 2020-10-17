/*
 * 本程序用于管理管道的创建,读取,写入操作
 * */
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>


void sys_err(const char *str)
{
    perror(str);
    exit(1);
}

int create_pipe(char *pipe_name)
{
    if(access(pipe_name, R_OK|W_OK) != -1)
        return 0;
    if(mkfifo(pipe_name,0644) < 0)
    {
        perror("mkfifo");
        return -1;
    }
    return 0;
}

int read_pipe(char *pipe_name,char *result)
{
    int fd;
    if((fd = open(pipe_name,O_RDONLY,0)) < 0)
    {
        perror("open");
        return -1;
    }
//  printf("start read pipe\n");
    if(fd != -1)
    {
        if(read(fd,result,1000) != -1)
        {
            return 0;
        }
    }
    close(fd);
    return 0;
}

int write_pipe(char *pipe_name,char *content)
{
    int fd;
    if((fd = open(pipe_name,O_WRONLY,0)) < 0)
    {
        perror("open");
        return -1;
    }
//  printf("start write pipe\n");
    if(fd != -1)
    {
        if(write(fd,content,1000) == -1)
            return 0;
    }
    close(fd);
    return 0;
}
