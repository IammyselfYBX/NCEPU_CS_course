
```bash
man signal.h
man sigemptyset
```

```c
#include <signal.h>

int sigemptyset(sigset_t *set);

int sigfillset(sigset_t *set);

int sigaddset(sigset_t *set, int signum);

int sigdelset(sigset_t *set, int signum);

int sigismember(const sigset_t *set, int signum);

man 2 sigprocmask
#include <signal.h>
/* Prototype for the glibc wrapper function */
int sigprocmask(int how, const sigset_t *set, sigset_t *oldse
t);
   /* how
       - SIG_BLOCK：添加阻塞
       - SIG_UNBLOCK：解除阻塞
       - SIG_SETMASK：设置
      set：传入信号集
      oldset：旧的信号集，传出
   */
 
#include <signal.h>
int sigpending(sigset_t *set);
  /*
    set：传出参数，当前的未决信号集
  */
```
