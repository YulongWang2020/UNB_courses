public class Test {
    /**
     Searches the character grid for the appearance of a set of 3 identical characters, horizontally or vertically.
     @param searchGrid The 2D character array in which the search will occur.
     @return The character that was in the set.
     @throws SetNotFoundException if the searchGrid does not contain a set of exactly 3 matching characters.
     */
    public static char setSearchChar(char[][] searchGrid) throws SetNotFoundException {
        int height = searchGrid.length;
        int width = searchGrid[0].length;
        for(int col=0;col<width;col++){
            for(int row=0;row<height;row++){
                if(col - 1 >= 0 && col + 1<width){
                    if(searchGrid[row][col-1]==searchGrid[row][col] && searchGrid[row][col]==searchGrid[row][col+1]){
                        return searchGrid[row][col];
                    }
                }
                if(row - 1 >= 0 && row + 1<height){
                    if(searchGrid[row-1][col]==searchGrid[row][col] && searchGrid[row][col]==searchGrid[row+1][col]){
                        return searchGrid[row][col];
                    }
                }
            }
        }
        throw new SetNotFoundException("Set not found");
    }

    /**
     Exchanges the minimum values in the array parameters.
     @param numbers The array in which the minimum value will be swapped with the minimum value from the other array.
     @param values The array in which the minimum value will be swapped with the minimum value from the other array.
     */
    public static void swapMins (int[] numbers, int[] values) {
        int min_num = Integer.MAX_VALUE;
        int min_val = Integer.MAX_VALUE;
        int min_num_index = 0;
        int min_val_index = 0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<min_num){
                min_num = numbers[i];
                min_num_index = i;
            }
        }
        for(int i=0;i<values.length;i++){
            if(values[i]<min_val){
                min_val = values[i];
                min_val_index = i;
            }
        }

        numbers[min_num_index] = min_val;
        values[min_val_index] = min_num;
    }

    public static int sumEven(int val){
        if(val==0){
            return 0;
        }
        if(val%2==0){
            return val%10 + sumEven(val/10);
        }else {
            return sumEven(val/10);
        }
    };

    public static void main(String[] args) throws SetNotFoundException {
//        char[][] search = {{'A','B','A','D'},{'B','Z','C','X'},{'X','C','C','C'}};
//        System.out.println(setSearchChar(search));
//        int[] testArr1 = {12, 7, 5, -4, 18, 22, 0};
//        int[] testArr2 = {13, -2, 1, 24, 8, 16};
//        swapMins(testArr1,testArr2);
        System.out.println(sumEven(111));
    }
}


class SetNotFoundException extends Exception{
    public SetNotFoundException(String message) {
        super(message);
    }
}
