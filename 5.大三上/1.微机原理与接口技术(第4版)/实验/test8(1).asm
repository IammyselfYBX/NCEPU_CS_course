;*************************;
;*  8253方式0计数器实验  *;
;*************************;
io8253a        equ 283h
io8253b        equ 280h
code segment
    assume  cs:code
start: mov al,14h     	  ;15----14h
     mov dx,io8253a
     out dx,al
     mov dx,io8253b     	 ;送计数初值
     mov al,0fh   		;10---0fh 0000
     out dx,al
lll:     in al,dx        	 ;读计数初值
     call disp        		;调显示子程序
     push dx  
     mov ah,06h 
     mov dl,0ffh
     int 21h
     pop dx
     jz lll
     mov ah,4ch       ;退出
     int 21h
disp  proc near        ;显示子程序
     push dx
     and al,0fh  		 ;0f0---0fh    
     mov dl,al
     cmp dl,9         ;判断是否<=9
     jle  num  		;jge-----jle num      
     add dl,7         
num: add dl,30h
     mov ah,02h       ;显示
     int 21h
     mov dl,0dh       ;加回车符
     int 21h
     mov dl,0ah       ;加换行符
     int 21h
     pop dx
     ret              ;子程序返回
disp endp
code ends
end start 