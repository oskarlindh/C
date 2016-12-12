#include <stdlib.h>
#include <stdbool.h>
#include <stdint.h>
#include <assert.h>
#include <stdio.h>
#include "heap_alloc.h"

/* typedef struct heap heap_t; */

#define header_mask ~0b11

typedef struct {
  bool active;
} page_header;

struct heap {
  size_t size;
  float threshhold;
  bool unsafe_stack;
  void *memblock;
  void *front; // next free memory address
  const void *start_address;
  page_header *pages;
};

typedef union {
  char *format; // type = 0
  void *forward; // type = 2
  uint64_t layout; // type = 3
  
  struct {
    uint64_t type : 2; // bitfield
  };
} object_header;

/* headern används som en uint64_t */
/* ((union header) ).type för att få typen */
/* ((union header) ( & header_mask)).{format/forward/layout} för att få data */

// Return a / b rounded up to closest integer 
#define CEIL(a, b) ((a) % (b)) == 0 ? ((a) / (b)) : ((a) / (b) + 1)
#define PAGE_SIZE 2048

heap_t *h_init(size_t bytes, bool unsafe_stack, float gc_threshold) {
  int nr_pages = CEIL(bytes, PAGE_SIZE);
  int size = nr_pages * PAGE_SIZE;
  heap_t *h = calloc(1, sizeof(heap_t));
  assert(h);
  
  h->pages = calloc(1, sizeof(page_header) * nr_pages);
  assert(h->pages);
  
  h->memblock = calloc(1, bytes);
  assert(h->memblock);
  
  h->unsafe_stack = unsafe_stack;
  h->size = size;
  h->threshhold = gc_threshold;
  h->front = (h->memblock);
  h->start_address = (h->memblock);
  return h;
}

size_t h_used(heap_t *h) {
  return h->front - h->start_address;
}

bool h_space_available_on_page(heap_t *h, size_t bytes) {
  int used = h_used(h);
  int current_page = used/PAGE_SIZE;
  int next_page = current_page + 1;

  /* TODO fixa varningen */
  if((used + bytes) / PAGE_SIZE == next_page) {
    return false;
  } else {
    return true;
  }
}

void *h_alloc_data(heap_t *h, size_t bytes) {
  /* TODO - make sure the page you are writing to becomes active */
  /* TODO - make sure there is enough space on current page */
  /* TODO - make sure there is enough space on heap */
  
  // place header on first available place
  object_header *oh = h->front;
  h->front += sizeof(object_header);
  // save forward address and set correct type 
  oh->forward = h->front;
  oh->type = 2;
  // place the object on first available place
  void *object = h->front;
  h->front += bytes;
  // decreace the remaining size of the heap
  h->size -= bytes + sizeof(object_header);
  return object;
}

int format_offset(char* format, int* i) { // TODO 32/64-bit & alignment
  int num = -1;
  while(format[*i]) {
    char c = format[(*i)++];
    if('0' <= c && c <= '9') {
      num = num == -1 ? c - '0' : num * 10 + c - '0';
    } else {
      switch(c) { 
      case '*': return num == -1 ? sizeof(void*)  : num * sizeof(void*);
      case 'i': return num == -1 ? sizeof(int)    : num * sizeof(int);
      case 'f': return num == -1 ? sizeof(float)  : num * sizeof(float);
      case 'c': return num == -1 ? sizeof(char)   : num * sizeof(char);
      case 'l': return num == -1 ? sizeof(long)   : num * sizeof(long);
      case 'd': return num == -1 ? sizeof(double) : num * sizeof(double);
      }
    }
  }

  if(num != -1) {
    return num;
  } else {
    return 0;
  }
}

int format_size(char* format) {
	int size = 0;
	for(int i = 0;; ) {
		int offset = format_offset(format, &i);
		if(offset == 0) {
			break;
		} else {
			size += offset;
		}
	}
	return size;
}

void h_delete(heap_t *h) {
  free(h->memblock);
  free(h->pages);
  free(h);
}

size_t h_avail(heap_t *h) {
  return h->size;
}

void *h_alloc_struct(heap_t *h, char *layout) {
  return NULL;
}

