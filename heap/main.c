#include <stdio.h>
#include "heap_alloc.h" 
int main(int argc, char *argv[])
{
    int hello = 0;
    int *haj = &hello;
    char *hej = "iiiicc";
    printf("%i\n",format_size(hej));
    printf("%i\n", &hello);
    
    int her = haj+1;
    printf("%i\n", her);
    //read_string("hej");        
    return 0;

}
