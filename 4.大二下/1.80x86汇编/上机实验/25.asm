
;要求从键盘接收一个四位的16 进制数，并在终端上显示与它等值的二进制数。

DATAS  SEGMENT

DATAS  ENDS

CODES  SEGMENT
     ASSUME    CS:CODES
     
START:   
     MOV CH, 4
     MOV BX, 0
LP3:  
     MOV AH, 1
     INT   21H   
     CMP  AL, 3AH
     JB    LP1
     SUB  AL, 37H
     JMP  LP2
LP1: 
     SUB  AL, 30H
LP2:  
     MOV CL, 4
     SHL BX, CL
     OR   BL, AL
     DEC  CH
     JNZ   LP3
     MOV DL, 0AH        ;换行 
     MOV AH, 2
     INT   21H
     MOV DL, 0DH        ;回车
     MOV AH, 2
     INT  21H   
     MOV  CX, 16
LP6:  
     SHL  BX, 1
     JC  LP4
     MOV DL, 30H
     JMP LP5
LP4:  
     MOV DL, 31H
LP5:  
     MOV AH, 2
     INT  21H    
     LOOP LP6
     MOV AH, 4CH
      INT  21H     
CODES    ENDS
              END START

