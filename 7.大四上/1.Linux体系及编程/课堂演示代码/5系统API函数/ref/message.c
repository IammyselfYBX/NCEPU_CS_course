/*
 * 本程序用来管理信号量机制
 * */
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <errno.h>
#include <string.h>

typedef struct
{
    long int nType;
    char szText[256];
}MSG;

char *load(char *pwd, char *filename)
{
    char path[1024];
    strcpy(path,pwd);
    strcat(path,"/");
    strcat(path,filename);
    return path;
}
void send_msg(char *content, char *pro_path)
{
    key_t IKey;
    int nMsgId;
    MSG msg;
    if((IKey = ftok (load(pro_path,"profile"),2)) == -1)
    {
        printf("send\n");
        perror("ftok");
        exit(1);
    }
    // 队列存在则退出，否则创建新的队列
    if((nMsgId = msgget(IKey,IPC_CREAT|IPC_EXCL|0666)) == -1)
    {
        if(errno != EEXIST)     /* 消息队列创建失败 */
        {
            perror("msgget");
            exit(2);
        }
        if((nMsgId = msgget(IKey,0)) == -1)  /* 消息队列已存在 */
        {
            perror("msgget");
            exit(3);
        }
    }
    memset(&msg,0x00,sizeof(MSG));      /* 清空队列结构 */
    msg.nType = 2;
    memcpy(msg.szText,content,strlen(content));
    if(msgsnd(nMsgId,(const void *)&msg,strlen(msg.szText),IPC_NOWAIT) <0)
    {
        printf("error\n");
        perror("msgsnd");
    }
}
void receive_msg(char *rcv_msg, char *pro_path)
{
    key_t IKey;
    int n,nMsgId;
    MSG msg;
    if((IKey = ftok (load(pro_path,"profile"),2)) == -1)
    {
        printf("receive\n");
        perror("ftok");
        exit(1);
    }
    if((nMsgId = msgget(IKey,0)) == -1)  /* 消息队列已存在 */
    {
        printf("receive\n");
        perror("ftok");
        exit(2);
    }
    memset(&msg,0x00,sizeof(MSG));      /* 清空队列结构 */
    if((n = msgrcv(nMsgId,(const void *)&msg,sizeof(msg.szText),2L,0)) <0)
    {
        perror("msgrcv");
    }
    else
    {   
        strcpy(rcv_msg,msg.szText);
//      return msg.szText;
    }
}
