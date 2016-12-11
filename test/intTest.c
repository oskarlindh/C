#include <stdio.h>

int main(int argc, char *argv[])
{
    int hej = 9;
    int *hello = &hej;
    
    printf("%p\n%i\n", hello,hej);
    
    return 0;
}
