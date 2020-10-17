# exec族
这一家族的函数的作用：执行其他程序

```c
#include <unistd.h>

extern char **environ;

///////////////////////////////////////////////////////
//这个执行的时候不使用PATH环境变量，所以执行ls用加绝对路径
int execl(const char *pathname, const char *arg, ...
                /* (char  *) NULL */);
eg:
execl(/bin/ls, "lll", "-l", NULL)
//这个执行的时候使用PATH环境变量，所以执行ls不用加绝对路径
int execlp(const char *file, const char *arg, ...
                /* (char  *) NULL */);
///////////////////////////////////////////////////////


int execle(const char *pathname, const char *arg, ...
                /*, (char *) NULL, char *const envp[] */);
int execv(const char *pathname, char *const argv[]);
int execvp(const char *file, char *const argv[]);
int execvpe(const char *file, char *const argv[],
                char *const envp[]);
```

