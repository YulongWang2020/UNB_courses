public class FindNumber {
    public static void main(String[] args) {
        int[][] temp = {
                {-7,-1,0,0,9,0,0,0,0},
                {0,0,1,0,0,0,3,5,0},
                {2,3,2,4,2,-3,-3,0,0},
                {0,0,0,0,0,0,0,0,11},
        };

        System.out.println(sumConnected(temp,0,0));
    }

    /**
     This method sums the non-zero integers that are connected/adjacent to the starting position.
     @param map A reference to a 2D array.
     @param row The row number for a cell that is a non-zero integer.
     @param col The column number for a cell that is a non-zero integer.
     @return The sum of the non-zero integers that are connected/adjacent to the starting position.
     */
    public static int sumConnected(int[][] map, int row, int col){
        int height = map.length;
        int width = map[0].length;
        int sum = 0;
        if(row-1>0 && map[row-1][col]!=0){
            int curr = map[row-1][col];
            map[row-1][col] = 0;
            sum += curr + sumConnected(map,row-1,col);
        }
        if(row+1<height && map[row+1][col]!=0){
            int curr = map[row+1][col];
            map[row+1][col] = 0;
            sum += curr + sumConnected(map,row+1,col);
        }
        if(col-1>=0 && map[row][col-1]!=0){
            int curr = map[row][col-1];
            map[row][col-1] = 0;
            sum += curr + sumConnected(map,row,col-1);
        }
        if(col+1<width && map[row][col+1]!=0){
            int curr = map[row][col+1];
            map[row][col+1] = 0;
            sum += curr + sumConnected(map,row,col+1);
        }
        return sum;
    }
}
