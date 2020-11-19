/*
    一、C预处理器可以根据条件判断来忽略一部分代码。
    这里的 #ifndef 是“如果没有被定义”的意思,
    它会检查是否已经出现过 #define _object_h ,如果已出现,就跳过这段代码。
    因为我们可以将这个文件包含任意次,而无需担心多次定义里面的东西。
*/
#ifndef _object_h   
#define _object_h

typedef enum{
    NORTH, SOUTH, EAST, WEST
} Direction;

typedef struct {
    char *description;
    int (*init)(void *self);
    void (*describe)(void *self);
    void (*destroy)(void *self);
    void *(*move)(void *self, Direction direction);
    int (*attack)(void *self, int damage);
}Object;

int Object_init(void *self);
void Object_destroy(void *self);
void Object_describe(void *self);
void *Object_move(void *self, Direction direction);
int Object_attack(void *self, int damage);
void *Object_new(size_t size, Object proto, char *description);

#define NEW(T, N) Object_new(sizeof(T), T##Proto, N)    //类似模板函数,这里 T##Proto 表示“将Proto连接到T的末尾”,所以如果你写下 NEW(Room, "Hello.") ,就会在这里变成 RoomProto
#define _(N) proto.N
/*
    宏的单行定义（少见用法）
#define A(x) T_##x
#define B（x) #@x
#define C（x) #x
我们假设：x=1，则有：
A(1)------〉T_1
B(1)------〉'1'
C(1)------〉"1" 
*/

#endif