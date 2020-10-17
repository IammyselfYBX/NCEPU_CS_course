#include <stdio.h>
#include <string.h>


#include <unistd.h>
main()
{
    printf("current working directory: %s\n", getcwd(NULL, NULL));
    char tmp_path[100]="..";
    chdir(tmp_path);
    printf("current working directory: %s\n", getcwd(NULL, NULL));
    strcpy(tmp_path, "/");
    chdir(tmp_path);
    printf("current working directory: %s\n", getcwd(NULL, NULL));
}
