import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yulong Wang
 * @date 2021/10/06
 */
public class Cavern {
    /**
     * The width of the array represents the cavern
     */
    private final int width;
    /**
     * The height of the array represents the cavern
     */
    private final int height;
    /**
     * The array represents the cavern
     */
    private int[][] cavern;

    /**
     * @param height The height of the cavern
     * @param width  The width of the cavern
     * @param cavern The array that represents the cavern
     */
    public Cavern(int height, int width, int[][] cavern) {
//      assume the input is valid, this means height and width is always larger than 0;
        this.height = height;
        this.width = width;
        this.cavern = cavern;
    }

    /**
     * This method calculate and print the area of the cavern that is accessible.
     */
    public void showCavernArea(){
        int visited = 0;
        Queue<int[]> q = new LinkedList<>();
//        find the valve
        int i;
        for(i=0;i<cavern[0].length;i++){
            if(cavern[0][i] == 0){
                int[] temp = {0,i};
                cavern[0][i] = 3;
                q.offer(temp);
                visited ++;
                break;
            }
        }
        visited += findZeros(0,i);
//      print the result
        for(i=0;i<height;i++){
            for(int j=0;j<width;j++){
                System.out.print(cavern[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("The area of the cavern is: "+visited);
    }

    /**
     * @param row the row index of cavern array to find zero around
     * @param col the column index of cavern array to find zero around
     * @return int number of connected zeros found.
     */
    public int findZeros(int row, int col){
        int sum = 0;
        if(row-1>0 && cavern[row-1][col]==0){
            cavern[row-1][col] = 3;
            sum += 1 + findZeros(row-1,col);
        }
        if(row+1<height && cavern[row+1][col]==0){
            cavern[row+1][col] = 3;
            sum += 1 + findZeros(row+1,col);
        }
        if(col-1>=0 && cavern[row][col-1]==0){
            cavern[row][col-1] = 3;
            sum += 1 + findZeros(row,col-1);
        }
        if(col+1<width && cavern[row][col+1]==0){
            cavern[row][col+1] = 3;
            sum += 1 + findZeros(row,col+1);
        }
        return sum;
    };
}
