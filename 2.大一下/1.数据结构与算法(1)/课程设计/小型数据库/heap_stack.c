/*
    @Author:杨秉学
    @Time: 2018 7
    @Function: 在这个程序中我使用了一系列的结构来创建用于地址薄的小型数据库。
    堆和栈的内存分配
    栈和堆的差异取决于取得储存空间的位置
    1.堆容易解释,因为它就是你电脑中的剩余内存,你可以通过 malloc 访问它来获取更多内存,
    OS会使用内部函数为你注册一块内存区域,并且返回指向它的指针。
    当你使用完这片区域时,你应该使用 free 把它交还给OS,使之能被其它程序复用。如果你不这样做就会导致程序“泄露”内存,
    
    2.栈是一个特殊的内存区域,它储存了每个函数的创建的<临时变量>,它们对于该函数为<局部变量>。
    它的工作机制是,函数的每个函数都会“压入”栈中,并且可在函数内部使用。
    这对于 main 中所有类似 char section 和 int id 的局部变量也是相同的。
    使用栈的优点是,当函数退出时C编译器会从栈中“弹出”所有变量来清理。这非常简单,也防止了栈上变量的内存泄露。
*/
#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>

#define MAX_DATA 512
#define MAX_ROWS 100

struct Address {    //结构体是定长的
    int id;
    int set;
    char name[MAX_DATA];
    char email[MAX_DATA];
};

struct Database {
    struct Address rows[MAX_ROWS];
};

struct Connection{
    FILE *file;
    struct Database *db;
};

/*
    在像这样的小型程序中,你可以编写一个单个函数在出现错误时杀掉程序。
    我把它叫做 die 。任何失败的函数调用,或错误输出之后,它会调用 exit 带着错误退出程序。
*/
void die(const char *message)
{
    if(errno){
        perror(message);    //使用 perror 来“打印出错误信息”。
    }else{
        printf("ERROR!: %s\n", message);
    }

    exit(1);
}

void Address_print(struct Address *addr)
{
    printf("%d %s %s\n", addr->id, addr->name, addr->email);
}

void Database_load(struct Connection *conn)
{
    int rc = fread(conn ->db, sizeof(struct Database), 1, conn->file);
    if(rc != 1){
        die("Failed To load database.");
    }
}

struct Connection *Database_open(const char *filename, char mode)
{
    struct Connection *conn = malloc(sizeof(struct Connection));
    if(!conn){
        die("Memory error");
    }

    conn->db = malloc(sizeof(struct Database));
    if(!conn->db) die("Memory error");

    if(mode == 'c'){
        conn ->file = fopen(filename, "w");
    }else{
        conn->file = fopen(filename, "r+");

        if(conn->file){
            Database_load(conn);
        }
    }

    if(!conn->file){
        die("Failed To load database.");
    }

    return conn;
}

void Database_close(struct Connection *conn)
{
    if(conn){
        if(conn->file){
            fclose(conn->file);
        }
        if(conn->db){
            free(conn->db);
        }
        free(conn);
    }
}

void Database_write(struct Connection *conn)
{
    rewind(conn->file);

    int rc = fwrite(conn->db, sizeof(struct Database), 1, conn->file);
    if(rc != 1){
        die("Failed To load database.");
    }

    rc = fflush(conn->file);
    if(rc == -1){
        die("Cannot flush database.");
    }
}

void Database_create(struct Connection *conn)
{
    int i = 0;

    for(i = 0; i < MAX_ROWS; i++)
    {
        struct Address addr = {.id = i, .set = 0};
        conn ->db->rows[i] = addr;
    }
}

void Database_set(struct Connection *conn, int id, const char *name, const char *email)
{
    struct Address *addr = &conn->db->rows[id];
    if(addr->set){
        die("Already set, delete it first");
    }

    addr->set = 1;
    char *res = strncpy(addr->name, name, MAX_DATA);
    if(!res){
        die("Name copy failed");
    }

    res = strncpy(addr->email, email, MAX_DATA);
    if(!res){
        die("Email copy failed");
    }
}

void Database_get(struct Connection *conn, int id)
{
    struct Address *addr = &conn->db->rows[id];

    if(addr->set){
        Address_print(addr);
    }else{
        die("ID is not set");
    }
}

void Database_delete(struct Connection *conn, int id)
{
    struct Address addr = {.id = id, .set = 0};
    conn->db->rows[id] = addr;
}

void Database_list(struct Connection *conn)
{
    int i = 0;
    struct Database *db = conn->db;

    for(i = 0; i<MAX_ROWS; i++){
        struct Address *cur = &db->rows[i];

        if(cur->set){
            Address_print(cur);
        }
    }
}

int main(int argc, char *argv[])
{
    if(argc < 3)
    {
        die("USAGE:heap_stack <dbfile> <action> [action params]");
    }
    char *filename = argv[1];
    char action = argv[2][0];
    struct Connection *conn = Database_open(filename, action);
    int id = 0;

    if(argc > 3){
        id = atoi(argv[3]);
    }
    if( id >= MAX_ROWS){
        die("There's not that many reconds.");
    }

    switch(action){
        case 'c':
            Database_create(conn);
            Database_write(conn);
            break;
        case 'g':
            if(argc != 4){
                die("Need an id to get");
            }

            Database_get(conn, id);
            break;
        case 's':
            if(argc != 6){
                die("Need id, name, email to set");
            }

            Database_set(conn, id, argv[4], argv[5]);
            Database_write(conn);
            break;
        case 'd':
            if(argc != 4){
                die("Need id to delete");
            }

            Database_delete(conn, id);
            Database_write(conn);
            break;
        case 'l':
            Database_list(conn);
            break;
        default:
            die("Invalid action, only: c=create, g=get, s=set, d=del, l=list");
    }

    Database_close(conn);

    return 0;
}