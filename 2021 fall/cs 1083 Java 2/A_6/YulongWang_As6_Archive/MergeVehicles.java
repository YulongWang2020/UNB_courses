import java.io.*;

/**
 * @author Yulong Wang
 * @date 2021/10/26
 */
public class MergeVehicles {
    /**
     * Read two binary file and print their vehicle objects.
     * @param args Two file names
     */
    public static void main(String[] args) {
        if(args.length!=2){
            System.out.println("Missing parameters");
            System.exit(0);
        }
        for(String fileName : args){
            try {
                FileInputStream fi = new FileInputStream(fileName);
                ObjectInputStream inputStream = new ObjectInputStream(fi);
                boolean eof = false;
                while(!eof){
                    try{
                        Vehicle temp = (Vehicle)inputStream.readObject();
                        System.out.println(temp.toString());
                    }catch (EOFException e){
                        System.out.println("Reach end of file");
                        eof = true;
                    }
                }
            }catch (FileNotFoundException e){
                System.out.println("Not able to access file.");
            }catch (ClassNotFoundException e) {
                System.out.println("Class not found");
            }catch (IOException e){
                System.out.println("Problem reading from file");
            }
        }
    }
}
