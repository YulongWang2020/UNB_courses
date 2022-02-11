import java.io.*;
import java.util.Scanner;
import java.text.NumberFormat;

public class Driver {
	public static void main(String[] args) {
		NumberFormat form = NumberFormat.getCurrencyInstance();
		try {
			if(args.length<2){
				throw new FileNotFoundException("Missing parameters");
			}
			File file = new File(args[0]);
			Scanner scan = new Scanner(file);

			String name = scan.nextLine();
			int size = scan.nextInt();
			scan.nextLine();

			Vehicle[] inventory = new Vehicle[size];
			int counter = 0;
			for (int i = 0; i < size; i++) {
				String line = scan.nextLine();
				Scanner sc = new Scanner(line);
				String code = sc.next();
				int mileage = sc.nextInt();
				Vehicle temp;
				if (code.charAt(0) == 'C') {
					int doors = sc.nextInt();
					char type = sc.next().charAt(0);
					try {
						temp = new Car(code, mileage, type, doors);
					} catch (InvalidVehicleException e) {
						System.out.println(e.getMessage());
						continue;
					}

				} else if (code.charAt(0) == 'T') {
					String bed = sc.next();
					try {
						temp = new Truck(code, mileage, bed);
					} catch (InvalidVehicleException e) {
						System.out.println(e.getMessage());
						continue;
					}

				} else {
					String bool = sc.next();
					boolean isElect = false;
					if (bool.equals("true")) {
						isElect = true;
					}
					temp = new Van(code, mileage, isElect);
				}
				counter ++;
				inventory[i] = temp;
			}
			Vehicle[] temp = new Vehicle[counter] ;
			int j=0;
			for (Vehicle vehicle:inventory){
				if(vehicle!=null){
					temp[j] = vehicle;
					j++;
				}
			}

			Dealership dealer = new Dealership(name, temp);

			System.out.println(dealer);

			System.out.println("\nSorted Data:\n");

			Sorter<Vehicle> sort = new Sorter<Vehicle>();
			Vehicle[] copy = dealer.getInventory();

			sort.selectionSort(copy);

			System.out.println(dealer.getName());

			for (Vehicle v : copy) {
				System.out.println(v.getCode() + "\t" + form.format(v.calculatePrice()) + "\n");
			}

			while (scan.hasNext()) {
				String searchCode = scan.nextLine();
				System.out.println("Vehicle " + ((dealer.search(searchCode) == null) ? "not" : "") + " found");
			}
			FileOutputStream fo = new FileOutputStream(args[1]);
			ObjectOutputStream outputStream = new ObjectOutputStream(fo);
			for (Vehicle vehicle : copy) {
				outputStream.writeObject(vehicle);
			}
		}catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}catch (IOException e){
		System.out.println(e.getMessage());
		}
	}
}