;*******************************;
;*         电子琴实验          *;
;*******************************;

data segment
io8255a        equ 288h
io8255b        equ 28bh
io8253a     equ 280h
io8253b        equ 283h
table dw 524,588,660,698,784,880,988,1048;高音的
;table dw 262,294,330,347,392,440,494,524;低音的
msg db 'Press 1,2,3,4,5,6,7,8,ESC:',0dh,0ah,'$'
data ends

code segment
assume cs:code,ds:data
start:
    mov ax,data
    mov ds,ax

    mov dx,offset msg
    mov ah,9
    int 21h              ;显示提示信息
sing:    
    mov ah,7
    int 21h              ;从键盘接收字符,不回显
    cmp al,1bh
    je finish            ;若为ESC键,则转finish
    cmp al,'1'
    jl  sing
    cmp al,'8'
    jg sing              ;若不在'1'-'8'之间转sing
    
    sub al,31h
    shl al,1             ;转为查表偏移量
    mov bl,al            ;保存偏移到bx
    mov bh,0
    
    mov ax,4240H         ;计数初值 = 1000000 / 频率, 保存到AX
    mov dx,0FH
    div word ptr[table+bx]
    mov bx,ax
    
    mov dx,io8253b          ;设置8253计时器0方式3, 先读写低字节, 再读写高字节
    mov al,00110110B
    out dx,al

    mov dx,io8253a         
    mov ax,bx
    out dx,al            ;写计数初值低字节
    
    mov al,ah
    out dx,al            ;写计数初值高字节
    
    mov dx,io8255b          ;设置8255 A口输出
    mov al,10000000B
    out dx,al
    
    mov dx,io8255a            
    mov al,03h
    out dx,al            ;置PA1PA0 = 11(开扬声器)
    call delay           ;延时
    mov al,0h
    out dx,al            ;置PA1PA0 = 00(关扬声器)
    
    jmp sing
finish:
    mov ax,4c00h
    int 21h
    
delay proc near          ;延时子程序
    push cx
    push ax
    mov ax,15
x1: mov cx,0ffffh
x2: dec cx
    jnz x2
    dec ax
    jnz x1
    pop ax
    pop cx
    ret
delay endp
code ends
end start