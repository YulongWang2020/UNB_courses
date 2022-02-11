import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestCavernDriver {
    /**
     * @param args Test file path
     */
    public static void main(String[] args) {
        try{
            File file = new File(args[0]);
            Scanner sc = new Scanner(file);
            int row = sc.nextInt();
            int column = sc.nextInt();
            int[][] cavernArray = new int[row][column];
            sc.nextLine();
            int r = 0;
            while(sc.hasNextInt()){
                for(int i = 0; i<column;i++){
                    cavernArray[r][i] = sc.nextInt();
                }
                r ++;
            }
            Cavern cavern = new Cavern(row, column, cavernArray);
            cavern.showCavernArea();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No argument provided.");
        }catch (FileNotFoundException e){
            System.out.println("Can not find the file: " +args[0]);
        }

    }
}
