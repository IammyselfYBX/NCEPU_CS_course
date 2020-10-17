#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>

int main(int argc, char *argv[])
{
    char *p_f = "my_fifo";
    int fd = open(p_f, O_RDONLY);
    if(-1 == fd)
    {
        perror("open error");
    }

    char buf[256];
    while(1)
    {
        memset(buf, 0x00, sizeof(buf));
        int ret = read(fd, buf, sizeof(buf));
        if(-1 == ret)
        {
            perror("read error");
        }
        printf("%s", buf);
    }

    close(fd);

    return 0;
}
