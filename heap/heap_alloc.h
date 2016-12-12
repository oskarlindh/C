
#ifndef __heap_alloc__
#define __heap_alloc__


int format_offset(char* format, int* i); 
typedef struct heap heap_t;

int format_size(char* format);

void *h_alloc_struct(heap_t *h, char *layout);

void *h_alloc_data(heap_t *h, size_t bytes);

void read_string(char*layout);

#endif
