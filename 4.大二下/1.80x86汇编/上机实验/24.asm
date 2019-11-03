;将以BUFFER1为首地址的从小到大有序字节数组不重复传送至BUFFER2中


DATAS SEGMENT
    BUF1 DB 1,1,1,2,2,3,5,5
    COUNT EQU $-BUF1
    BUF2 DB COUNT DUP(?)
DATAS ENDS

STACKS SEGMENT

STACKS ENDS

CODES SEGMENT
    ASSUME CS:CODES,DS:DATAS,SS:STACKS,ES:DATAS
START:
    MOV AX,DATAS
    MOV DS,AX
    MOV ES,AX

    LEA DI,BUF1        ;取BUF字符串的偏移地址给DI
    LEA SI,BUF2
    MOV CX,COUNT 
    MOV BX,1H     
    SUB CX,BX          ;因为在循环之前已经操作了一次，所以CX要减1


    MOV AL,[DI]        ;先将数组第一个放入AX   
    MOV [SI],AL        ;并且把第一个数放入BUF2数组
    INC DI  
    INC SI             ;都从第二个开始
LOOP1: 
    CMP AL,[DI]        ;与AX中的比较，
    JE NEXT            ;相同的话，就往后循环
INSERT:
    MOV AL,[DI]        ;不同的话，先替换之前的 
    MOV [SI],AL        ;然后放入BUF2
    INC SI
NEXT:
    INC DI
    LOOP LOOP1

    MOV AH,4CH
    INT 21H
CODES ENDS
    END START
