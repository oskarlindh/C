#include <setjmp.h>
#include <stdio.h>
extern char **environ;

void hej()
{   
    int var = 123;
    int *ha = &var;
    void* caller = __builtin_frame_address(0);
    void* this = __builtin_frame_address(1);
    printf("\ncaller = %p\n",caller);
    printf("\this= %p\n\n",this);
    int i = 0;
    
    printf("Here ends the stack:%p\n\n", environ); 
    if(environ > caller )
        printf("%s\n","stack grows down" );
    
    else printf("%s\n", "the stack grows upp");
    //printf("int%p",ha);
}

