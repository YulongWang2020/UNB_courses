#include <stdio.h>
int main(int argc, char * * argv){
    int value;
    int iErr;
    int count = 0;
    printf("Value to examine: ");
    iErr = scanf("%d",&value);
    if(iErr != 1){
        printf("Unable to read the value\n");
        return 0;
    }else{
        while(value > 0){
            if(value%2 == 1){
                count++;
            }
            value = value/2;
        }
        printf("Number of ones: %d \n",count);
        return 1;
    }
}

