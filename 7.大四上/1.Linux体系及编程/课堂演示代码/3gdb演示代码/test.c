#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    int arr[10] = {10, 9, 23, 5, 3,6, 7,8, 9,11};
    int *p = (int *)malloc(9*sizeof(int));

    for (int i = 0; i < 9; i++) {
        p[i] = i;
    }
    free(p);

    return 0;
}
