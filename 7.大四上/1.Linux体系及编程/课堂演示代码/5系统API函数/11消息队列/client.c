#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/msg.h>
#include <sys/ipc.h>
#include <errno.h>
  
typedef struct mymesg
{
    long int mtype;
    char mtext[512];
}mymesg;

int main(int argc, char *argv[])
{
    int id = 0;
    mymesg ybx_msg;
    key_t key = ftok("my_message", 52);
    id = msgget(key, IPC_CREAT | 0666); //打开或者创建队列
    if (-1 == id) {
          perror("create msg error");
          exit(EXIT_FAILURE);
    }
    while(1)
    {
        if (-1 == msgrcv(id, (void *)&ybx_msg, sizeof(ybx_msg.mtext), 1,0)) {
            perror("Recive msg error ");
            exit(EXIT_FAILURE);
        }
        printf("Data:%s", ybx_msg.mtext);
        if(strncmp(ybx_msg.mtext,"exit",4) ==0)
			  {
            break;
        }
    }

    return 0;
}


