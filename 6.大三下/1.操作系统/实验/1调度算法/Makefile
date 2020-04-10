CFALGS = -Wall -g
#OBJS = CreateLink.c InitLinkQueue.c print_Link.c assert_begin.c get_Rp.c getfirst.c Hight_response.c 

OBJS = CreateLink.o InitLinkQueue.o print_Link.o assert_begin.o get_Rp.o getfirst.o Hight_response.o 

BIN := ./bin
OBJ := ./obj
SRC := ./src 

.PHONY=all clean debug
VPATH := $(SRC)
all:CHECKDIR main.bin 
	@mv *.o ./obj/
	@echo "succeed"

CHECKDIR:
	@mkdir $(BIN) $(OBJ)

main.bin:main.c $(OBJS)
	$(CC) $(CFALGS) $^ -o $(BIN)/$@

debug:
	@ gdb -q ./bin/main.bin

clean:
	rm -rf $(BIN) $(OBJS) $(OBJ)
