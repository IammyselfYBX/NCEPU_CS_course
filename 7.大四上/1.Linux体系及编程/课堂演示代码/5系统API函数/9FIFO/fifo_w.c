#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>

int main(int argc, char *argv[])
{
    char *p_f = "my_fifo";
    int fd = open(p_f, O_WRONLY);
    if (-1 == fd) {
        perror("open error");
    }

    char buf[256];
    int num = 0;
    while(1)
    {
        memset(buf, 0x00, sizeof(buf));
        sprintf(buf, "The num is %d\n", num++);
        write(fd, buf, sizeof(buf));
        sleep(1);
    }  

    close(fd);

    return 0;
}
