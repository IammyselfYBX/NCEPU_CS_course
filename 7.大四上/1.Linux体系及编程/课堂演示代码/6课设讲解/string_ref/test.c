/*
 * 实现字符串替换第一个 空格 分割的元素
 * */

#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
    char str[256]="ls -l\n";
    char *p;
    char *buff;
    buff = str;
    char tmp[100];
    p = strsep(&buff, " ");
    strncpy(tmp, "dir ", 4);
    while(p!=NULL)
    {
        strncat(tmp, p, strlen(p));
        strncat(tmp, " ", 1);
        p=strsep(&buff, " ");
    }
    printf("%s\n", tmp);

    return 0;
}
