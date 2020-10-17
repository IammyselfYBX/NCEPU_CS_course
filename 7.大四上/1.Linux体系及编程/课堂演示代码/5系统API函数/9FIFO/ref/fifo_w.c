#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>


int main(int argc, char *argv[])
{
    //当前目录存在my_fifo
    if(argc !=2)
    {
        printf("./fifo_w <filename>\n");
        return -1;
    }

    //刚才在当前目录创建一个 myfifo 了
    //打开 myfifo 
    int fd = open(argv[1], O_WRONLY);

    char buf[256];
    int num=0;
    while(1)
    {
        memset(buf, 0x00, sizeof(buf));
        sprintf(buf, "I am %4d\n", num++);
        write(fd, buf,sizeof(buf));
        sleep(1);
    }

    return 0;
}




