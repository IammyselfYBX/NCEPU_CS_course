#include <stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <errno.h>
#include <stdlib.h>
#include <string.h>


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
        char msg[256];
        memset(msg, 0x00, sizeof(msg));
        ybx_msg.mtype = 1;
        printf("Please Input messange: ");
        fgets(msg, sizeof(msg), stdin);
        strcpy(ybx_msg.mtext,msg);

        if (-1 == msgsnd(id, (void *)&ybx_msg, sizeof(ybx_msg.mtext), IPC_NOWAIT)) {
            perror("Send msg error: ");
            exit(EXIT_FAILURE);
        }

        if(strncmp(msg,"exit",4) == 0)
			  {
            break;
        }
    }
    if(-1 == msgctl(id, IPC_RMID, NULL)) //IPC_RMID从系统内核中移除消息队列
    {
        perror("Delete msg error ");
        exit(EXIT_FAILURE);
    }

    return 0;
}
