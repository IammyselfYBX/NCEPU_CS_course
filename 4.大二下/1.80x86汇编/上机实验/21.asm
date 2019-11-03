;冒泡排序（可以有负数，从大到小排序，FE=-2，FC=-4，FA=-6）

DATAS SEGMENT
	BUF DW 1,-2,3,-4,5,-6,7
	N EQU ($-BUF)/2
DATAS ENDS

STACKS SEGMENT

STACKS ENDS

CODES SEGMENT
	ASSUME CS:CODES,DS:DATAS,SS:STACKS
START:
	MOV AX,DATAS
	MOV DS,AX
	MOV CX,N
	DEC CX
LOOP1:
	MOV DI,CX
	MOV BX,0
            
LOOP2:
	MOV AX,BUF[BX]
	CMP AX,BUF[BX+2]           ;如果前面的小，后面的大，那就继续往后循环
	;--------------------------------------------------------------------------------带符号数比较---------------------
    JO YICHU          ;首先查看是否溢出(OF=1)，如果溢出跳到YICHU
    JMP MEIYICHU      ;否则就是没溢出（OF=0）

MEIYICHU:
    JNS DAYU         ;查看是否为正数（SF=0）,如果是正数跳到DAYU
    JMP NEXT2

YICHU:
    JS DAYU         ;查看是否为负数(SF=1),如果是负数跳到DAYU 
    JMP NEXT2

DAYU:    
	JMP NEXT
    ;---------------------------------------------------------------------------------带符号数比较--------------------
NEXT2:            
	XCHG AX,BUF[BX+2]          ;否则就交换    
	MOV BUF[BX],AX
NEXT:                     
	ADD BX,2
	LOOP LOOP2              ;内循环

	MOV CX,DI               ;注意：第一次循环完，DI=6，所以CX=6
	LOOP LOOP1              ;此时第二遍遍历，CX还要再减1，然后赋给DI，DI就=5，之后一直会递减，当DI=0时，停止循环
BREAKLOOP:
	MOV AH,4CH
	INT 21H
CODES ENDS
	END START