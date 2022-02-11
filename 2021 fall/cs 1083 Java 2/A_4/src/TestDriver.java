import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Test driver for Vehicle and Dealership classes
 * @author Yulong Wang
 * @date 2021/10/10
 */
public class TestDriver {
    /**
     * Helper function that create a vehicle instance using string input
     * @param line The string contain vehicle information
     * @return {@link Vehicle}
     */
    public static Vehicle createVehicle(String line) throws IndexOutOfBoundsException{
        String[] splited = line.split(" ");
        char carType = splited[0].charAt(0);
        switch (carType){
            case 'T':
                return new Truck(splited[0], Integer.parseInt(splited[1]), splited[2]);
            case 'C':
                return new Car(splited[0], Integer.parseInt(splited[1]), Integer.parseInt(splited[2]), splited[3]);
            case 'V':
                return new Van(splited[0], Integer.parseInt(splited[1]), Boolean.parseBoolean(splited[2]));
            default:
                return null;
        }
    }

    /**
     * Main function
     * @param args Terminal input
     * @throws FileNotFoundException Test case not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        String name = sc.nextLine();
        int numberOfCars = sc.nextInt();
        sc.nextLine();

        Vehicle[] inventory = new Vehicle[numberOfCars];
        for(int i=0;i<numberOfCars;i++){
            try{
                Vehicle vehicle = createVehicle(sc.nextLine());
                if(vehicle != null){
                    inventory[i] = vehicle;
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("Input is not valid");
            }
        }

        Dealership dealership = new Dealership(name, inventory);
//        print dealership after init
        System.out.println(dealership.toString());
//        sort inventory
        Sorter<Vehicle> sorter = new Sorter<Vehicle>();
        Vehicle[] sorted = dealership.getInventory();
        sorter.selectionSort(sorted);
//        print output
        Locale locale = new Locale("en", "CA");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        System.out.println("Sorted Data: \n");
        System.out.println(dealership.getName());
        for(Vehicle vehicle: sorted){
            System.out.println(String.format("%-7s Price: "+formatter.format(vehicle.calculatePrice())+"\n",vehicle.getCode()));
        }
//        search vehicles
        while(sc.hasNext()){
            System.out.println(dealership.findInventory(sc.nextLine()));
        }
    }
}
