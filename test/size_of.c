#include <stdio.h>

int size_of(void * S)
{
    return sizeof(S);
}

int main(int argc, char *argv[])
{
    char g = 'g';
    int v   = 2;
    char* hej = "hej hej hej hej hej hej hej hej hej"; 
    printf("%i\n",size_of(&g));
    return 0;
}


