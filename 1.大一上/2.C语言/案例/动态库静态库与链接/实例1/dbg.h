/**几乎每个编程语言中,错误处理都非常难。有些语言尽可能试图避免错误这个概
 * 念,而另一些语言发明了复杂了控制结构,比如异常来传递错误状态。当然的错误
 * 大多是因为程序员假定错误不会发生,并且这一乐观的思想影响了他们所用和所创
 * 造的语言。
 * 
 * C通过返回错误码或设置全局的 errno 值来解决这些问题,并且你需要检查这些
 * 值。这种机制可以检查现存的复杂代码中,你执行的东西是否发生错误。当你编写
 * 更多的C代码时,你应该按照下列模式:
 *      调用函数。
 *      如果返回值出现错误(每次都必须检查)。
 *      清理创建的所有资源。
 *      打印出所有可能有帮助的错误信息。
 * 这意味着对于每一个函数调用(是的,每个函数)你都可能需要多编写3~4行代码来确保它正常功能。
 * 解决重复书写大量重复代码的方法之一就是————利用宏
 * 
 * 
 * 之所以需要错误处理，是因为发生错误时,C程序会像你以前做的那样直接退出。不需要清理任何东西,因为OS会为你自动去做
 * 然而现在很多C程序需要持续运行数周、数月或者数年,并且需要优雅地处理来自于多种资源的错误。
 * */

//我现在会向你展示你目前所见过的,最强大且卓越的代码的全部内容。
#ifndef _dbg_h_
#define _dbg_h_

#include <stdio.h>
#include <errno.h>
#include <string.h>

#ifdef NDEBUG
#define debug(M, ...)   //#define debug() 被替换为空(右边没有任何东西)
#else
#define debug(M, ...) fprintf(stderr, "DEBUG %s: %d: " M "\n", __FILE__, __LINE__, ##__VA_ARGS__) //是两个_
//用 debug("format", arg1, arg2) 的地方替换成 fprintf 对 stderr 的调用。
//使用 ##__VA_ARGS__ ,意思是将剩余的所有额外参数放到这里。同时也要注意,使用了 __FILE__ 和 __LINE__ 来获取当前 file:line 用于调试信息。
#endif

//clean_errno 宏用于获取 errno 的安全可读的版本。
#define clean_errno() (errno == 0 ? "None" : strerror(errno))

//log_err , log_warn 和 log_info 宏用于为最终用户记录信息。
#define log_err(M, ...) fprintf(stderr, "[ERROR] (%s:%d: errno:%s) " M "\n", __FILE__, __LINE__, clean_errno(), ##__VA_ARGS__)
#define log_warn(M, ...) fprintf(stderr, "[WARN] (%s:%d: errno:%s) " M "\n", __FILE__, __LINE__, clean_errno(), ##__VA_ARGS__)
#define log_info(M, ...) fprintf(stderr, "[INFO] (%s:%d) " M "\n", __FILE__, __LINE__, ##__VA_ARGS__)

//check 会保证条件 A 为真,否则会记录错误 M (带着 log_err 的可变参数),之后跳到函数的 error: 区域来执行清理。
#define check(A, M, ...) if(!(A)) { log_err(M, ##__VA_ARGS__); errno=0; goto error; }

//sentinel 可以放在函数的任何不应该执行的地方,它会打印错误信息并且跳到 error: 标签。
//你可以将它放到 if-statements 或者 switch-statements 的不该被执行的分支中,比如 default 。
#define sentinel(M, ...) { log_err(M, ##__VA_ARGS__); errno=0; goto error; }

//简写的 check_mem 宏,用于确保指针有效,否则会报告“内存耗尽”的错误。
#define check_mem(A) check((A), "Out of memory.")

//用于替代的 check_debug 宏,它仍然会检查并处理错误,尤其是你并不想报告的普遍错误。它里面使用了 debug 代替 log_err 来报告错误
#define check_debug(A, M, ...) if(!(A)) { debug(M, ##__VA_ARGS__); errno=0; goto error; }
#endif