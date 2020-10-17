CFLAGS=-Wall -g
CC=gcc
all :demo background

demo:main.o message.o pipe.o
	$(CC) $(CFLAGS) $^ -o $@

background:background.o message.o pipe.o
	$(CC) $(CFLAGS) $^ -o $@

main.o:main.c
	$(CC) -c $^ -o $@

message.o:message.c
	$(CC) -c $^ -o $@

pipe.o:pipe.c
	$(CC) -c $^ -o $@

background.o:background.c
	$(CC) -c $^ -o $@


clean:
	rm *.o demo background
