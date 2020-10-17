#include <stdio.h>
#include <string.h>

#define MAX_TMP 100

/*
 * src：原来的字符串
 * replacement：要替换的部分
 * result：返回最终的结果
 * */
void replace(char *src, char *replacement, char *result)
{
    char *p;
    char *buff;
    buff = src;
    p = strsep(&buff, " ");
    p = strsep(&buff, " ");
    memset(result, 0x00, sizeof(result));
    strncpy(result, replacement, strlen(replacement));
    while(p!=NULL)
    {
        strncat(result, p, strlen(p));
        strncat(result, " ", 1);
        p = strsep(&buff, " ");
    }
}

int main(int argc, char *argv[])
{

    char orgin[100]="ls --l -a --color";
    char result[100];
    replace(orgin, "dir ", result);
    printf("%s\n", result);

    return 0;
}
