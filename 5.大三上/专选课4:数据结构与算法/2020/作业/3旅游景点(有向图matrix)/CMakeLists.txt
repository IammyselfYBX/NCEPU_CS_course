set(CMAKE_EXPORT_COMPILE_COMMANDS 1)
#cmake -DCMAKE_EXPORT_COMPILE_COMMANDS=1

cmake_minimum_required(VERSION 2.8.9)
project(test)

#Bring the headers, such as Student.h into the project
include_directories(include)

#Can manually add the sources using the set command as follows:
set(SOURCES src/main.c src/Queue.c src/create.c src/Traverse.c src/Prim.c src/Floyd.c src/Stack.c src/Dijkstra.c src/DisNetGraph.c src/AddArc.c src/AddVex.c)

# 如果需要 .h 的文件也要写到里面
add_executable(main.bin ${SOURCES})
