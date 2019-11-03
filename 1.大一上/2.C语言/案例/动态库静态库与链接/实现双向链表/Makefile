CFLAGS=-g -Wall -O2 -Wextra -Iinclude -rdynamic -DNDEBUG $(OPTFLAGS) 	#OPTFLAGS 变量可以让使用者按需扩展构建选项。
LIBS=-ldl $(OPTLIBS)	#用于链接库的选项
PREFIX?=/usr/local		#设置一个叫做 PREFIX 的可选变量,它只在没有 PREFIX 设置的平台上运行Makefile时有效,这就是 ?= 的作用。

SOURCES=$(wildcard src/**/*.c src/*.c)		#通过执行 wildcard 搜索在 src/ 中所有 *.c 文件来动态创建 SOURCES 变量。
OBJECTS=$(patsubst %.c, %.o, $(SOURCES))	#一旦你创建了源文件列表,你可以使用 patsubst 命令获取 *.c 文件的 SOURCES 来创建目标文件的新列表。你可以告诉 patsubst 把所有 %.c 扩展为 %.o ,并将它们赋给 OBJECTS

TEST_SRC=$(wildcard tests/*_tests.c)		#使用 wildcard 来寻找所有用于单元测试的测试源文件。
TESTS=$(patsubst %.c,%,$(TEST_SRC))			

TARGET=build/libdoublelink.a				#TARGET=build/libYOUR_LIBRARY.a最终目标设置为 build/libYOUR_LIBRARY.a ,你可以为你实际构建的任何库来修改它。
SO_TARGET=$(patsubst %.a,%.so,$(TARGET))	

# The Target Build
all: $(TARGET) $(SO_TARGET) tests			#要记住在没有提供目标时 make 会默认运行第一个目标。这里它叫做 all: ,并且它提供了 $(TARGET) tests 作为构建目标。查看 TARGET 变量,你会发现这就是库文件,所以 all: 首先会构建出库文件。之后, tests 目标会构建单元测试。
dev: CFLAGS=-g -Wall -Iinclude -Wextra $(OPTFLAGS)	#
dev: all

$(TARGET): CFLAGS += -fPIC			#构建 TARGET 库,然而它同样使用了15行的技巧,向一个目标提供选项来为当前目标修改它们。这里我通过适用 += 语法为库的构建添加了 -fPIC 。
$(TARGET): build $(OBJECTS)			#首先创建 build 目录,之后编译所有 OBJECTS 。运行实际创建 TARGET 的 ar 的命令。 $@ $(OBJECTS) 语法的意思是,将当前目标的名称放在这里,并把 OBJECTS 的内容放在后面。这里 $@ 的值为上一行的 $(TARGET) ,它实际上为 build/libYOUR_LIBRARY.a 。看起来在这一重定向中它做了很多跟踪工作,它也有这个功能,并且你可以通过修改顶部的 TARGET ,来构建一个全新的库。
	ar rcs $@ $(OBJECTS)			
	ranlib $@

$(SO_TARGET): $(TARGET) $(OBJECTS)
	$(CC) -shared -o $@ $(OBJECTS)

build:
	@mkdir -p build
	@mkdir -p bin

# The Unit Tests
.PHONY: tests
tests: CFLAGS += $(TARGET)
tests: $(TESTS)
	sh ./tests/runtests.sh

valgrind:
	VALGRIND="valgrind --log-file=/tmp/valgrind-%p.log" $(MAKE)

# The Cleaner
clean:
	rm -rf build $(OBJECTS) $(TESTS)
	rm -f tests/tests.log
	find . -name "*.gc*" -exec rm {} \;
	rm -rf `find . -name "*.dSYM" -print`

# The Install
install: all
	install -d $(DESTDIR)/$(PREFIX)/lib/
	install $(TARGET) $(DESTDIR)/$(PREFIX)/lib/

# The Checker
BADFUNCS='[^_.>a-zA-Z0-9](str(n?cpy|n?cat|xfrm|n?dup|str|pbrk|tok|_)|stpn?cpy|a?sn?printf|byte_)'

check:
	@echo Files with potentially dangerous functions.
	@egrep $(BADFUNCS) $(SOURCES) || true