#include <stdio.h>
#include <signal.h>
#include <sys/types.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <stdlib.h>
#include <sys/stat.h>

static int order_num = 6;
char *windows_orders[6] = {"dir","rename","move","del","cd","exit"};
char *linux_orders[6] = {"ls","mv","mv","rm","cd","exit"};

char *order_change(char *windows_order)
{
    int i;
    char *temp;
    char *order_pre;
    char *order_para;

    //申请空间来存放命令
    if((temp = (char*)malloc(20*sizeof(char))) ==0)
    {
        perror("Malloc temp");
        exit(EXIT_FAILURE);
    }
    if((order_pre = (char*)malloc(20*sizeof(char))) ==0)
    {
        perror("Malloc order_pre");
        exit(EXIT_FAILURE);
    }
    if((order_para = (char*)malloc(20*sizeof(char))) ==0)
    {
        perror("Malloc order_para");
        exit(EXIT_FAILURE);
    }

    sscanf(windows_order,"%s%[^'\n']",order_pre,order_para);
    //printf("order_pre   :%s\n",order_pre);
    //printf("order_para   :%s\n",order_para);

    if(!strcmp(order_pre,"cd") && strlen(order_para) == 0)
        return "pwd";
    else if(!strcmp(order_pre,"cd") && strlen(order_para) != 0)
    {
        chdir("home");
    }
    for(i=0;i<order_num;i++) 
    {
        if(strstr(order_pre,windows_orders[i]) != 0)
        {
            strcpy(temp,linux_orders[i]);
            strcat(temp,order_para);
            return temp;
        }
    }
    return "";
}

char *loadpath(char *pwd, char *filename)
{
    char path[1024];
    strncpy(path,pwd,strlen(pwd));
    strncat(path,"/", 1);
    strncat(path,filename, strlen(filename));
    return path;
}

int main(int argc, char *argv[])
{
    pid_t pid;
    char *win_order;
    char *linux_order;
//  Why ?   Segmentation fault (core dumped)
    if((win_order = (char*)malloc(20*sizeof(char))) == 0)
    {
        perror("Malloc win_order");
        exit(EXIT_FAILURE);
    }
    if((linux_order = (char*)malloc(20*sizeof(char))) ==0)
    {
        perror("Malloc linux_order");
        exit(EXIT_FAILURE);
    }
    char result[1001];
    char pwd[1024];
    char pro_path[1024];
    getcwd(pro_path,1024);
    create_pipe(loadpath(pro_path,"lx_pipe"));
    create_pipe(loadpath(pro_path,"syn_pipe"));
    create_pipe(loadpath(pro_path,"pwd_pipe"));
    signal(SIGCLD,SIG_IGN);
    switch(pid=fork())
    {
        case -1:
            perror("fork");
            break;
        case 0:         /* 子进程 */
        {
            if(execl(loadpath(pro_path,"background"),NULL)== -1)
            {
                perror("execl");
                exit(0);
            }
            break;
        }
        default:        /* 父进程 */
        {
            while(1)
            {
                read_pipe(loadpath(pro_path,"pwd_pipe"),&pwd);
                sscanf(pwd,"%[^ ]",pwd);
                printf("%s:",pwd);
                gets(win_order);
                //

                if(strcmp(win_order,"exit") == 0)
                {
                    kill(pid,SIGKILL);
                    exit(0);
                }
                linux_order = order_change(win_order);
                write_pipe(loadpath(pro_path,"syn_pipe"),"Start Send");
                //  发送msg
                //if(strlen(linux_order) == 0)
                //{
                //  printf("Couldn't found the order,please check your order\n");
                //  continue;
                //}
                send_msg(linux_order,pro_path);
                //  读取pipe
                read_pipe(loadpath(pro_path,"lx_pipe"),&result);
                printf("%s\n",result);
            }
            break;
        }
    }
}
