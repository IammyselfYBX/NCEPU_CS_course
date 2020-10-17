#include <stdio.h>
#include <string.h>
#include <unistd.h> 
//execute shell command
//执行一个shell命令，输出结果逐行存储在resvec中，并返回行数
void myexec(const char *cmd, char *resvec) {

    int line_num = 0;
    char path[1024];
    strcpy(resvec,"");
    if(strstr(cmd,"cd") != 0)
    {
    sscanf(cmd,"%*s%s",path);
    int error = chdir(path);
    if(error == -1)
        strcpy(resvec,"error: couldn't find the filepath");
    return;
    }
    FILE *pp = popen(cmd, "r"); //建立管道
    if (!pp) {
        return;
    }
    char tmp[1024]; //设置一个合适的长度，以存储每一行输出
    while (fgets(tmp, sizeof(tmp), pp) != NULL) {
        if (tmp[strlen(tmp) - 1] == '\n') {
            tmp[strlen(tmp) - 1] = '\0'; //去除换行符
       }
    if(strlen(tmp) > 12)
    {
        sprintf(tmp, "%-24s", tmp);
        line_num++;
    }
    else
        sprintf(tmp, "%-12s", tmp); //标准格式
        strcat(resvec,tmp);
    if(++line_num % 6 == 0)
        strcat(resvec,"\n");
    }
    pclose(pp); //关闭管道
    return;
}
char *loadpath(char *pwd, char *filename)
{
    char path[1024];
    strcpy(path,pwd);
    strcat(path,"/");
    strcat(path,filename);
    return path;
}

int main(int argc, char *argv[])
{
    char resvec[1000];
    char rev_msg[256];
    char rcv_p[20];
    char pro_path[1024];
    getcwd(pro_path,1024);
    while(1)
    {
        myexec("pwd",&resvec);
        write_pipe(loadpath(pro_path,"pwd_pipe"),resvec);
        read_pipe(loadpath(pro_path,"syn_pipe"),&rcv_p);
        receive_msg(&rev_msg,pro_path);
        myexec(rev_msg,&resvec);
        //printf("%s\n",resvec);//打印容器的内容
        write_pipe(loadpath(pro_path,"lx_pipe"),resvec);

    }
}
