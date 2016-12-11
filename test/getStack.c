#include <setjmp.h>
#include <stdio.h>
#include "varStack.h"

#define Dump_registers() \
    jmp_buf env; \
if (setjmp(env)) abort(); \

int main(int argc, char *argv[])
{
    void* hello = __builtin_frame_address(0);
    printf("\nmain =%p\n",hello);
    hej();   
    return 0;
}





