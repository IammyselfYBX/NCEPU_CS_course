#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>

int main(int argc, char *argv[])
{
    if(argc != 2)
    {
        printf("Usage: ./cat_demo filename\n");
        exit(EXIT_FAILURE);
    }
     int fd = open(argv[1], O_RDONLY);
     char buf[1000];
     //read
     ssize_t ret_r = read(fd, buf, sizeof(buf));
     if(-1 == ret_r)
     {
         perror("read error");
         exit(EXIT_FAILURE);
     }
     //write
     ssize_t ret_w = write(STDIN_FILENO, buf, ret_r);
     if(-1 == ret_w)
     {
         perror("write error");
         exit(EXIT_FAILURE);
     }

    return 0;
}
