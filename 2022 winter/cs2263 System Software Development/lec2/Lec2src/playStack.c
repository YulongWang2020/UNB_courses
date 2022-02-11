// first.c
#include <stdio.h>
#include <stdlib.h>
#define MAX 256
#define PUSH 1
#define POP 0
#define LIST 2
int main(int argc, char* argv[])
{
  int stack[MAX];
  int size = 0;
  int val;
  int iChoice;
  int iNRead;
  int result;
  int newElement;
  int read;

  /* Processing loop */
  printf("Choice (1=add, 0=remove, 2=list): ");
  iNRead = scanf("%d", &iChoice);
  while(iNRead == 1)
  {
    switch(iChoice)
    {
      case PUSH:
        printf("Value to add: ");
        iNRead = scanf("%d", &newElement);
        if(size < MAX){
          stack[size] = newElement;
          size++;
        }
        // Read the element, add it to the stack
      break;
      case POP:
        result = stack[size-1];
        stack[size] = 0;
        size--;
        printf("Value poped: %d", result);
      // Print out the last element and remove it.
      break;
      case LIST:
        for(int i=0;i<size;i++){
          printf("%d\n",stack[i]);
        }
      break;
    }
    printf("Choice (1=add, 0=remove, 2=list): ");
    iNRead = scanf("%d", &iChoice);
  }
  return EXIT_SUCCESS;
}
