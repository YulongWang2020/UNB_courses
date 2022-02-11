// first.c
#include <stdio.h>
#include <stdlib.h>
int main(int argc, char * * argv)
{
  int a = 5;
  int b = 17;
  int iChoice;
  int iNRead;
  printf("main: a = %d, b = %d, argc = %d\n", a, b, argc);
  printf("Choice (1=add, 0=remove, 2=list): ");
  iNRead = scanf("%d", &iChoice);
  printf("%d", iNRead);
  return EXIT_SUCCESS;
}
