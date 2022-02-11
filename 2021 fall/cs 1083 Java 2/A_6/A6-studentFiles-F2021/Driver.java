import java.util.Scanner;
import java.text.NumberFormat;

public class Driver{
	public static void main(String[] args){
		NumberFormat form = NumberFormat.getCurrencyInstance();
	
		Scanner scan = new Scanner(System.in);

		String name = scan.nextLine();
		int size = scan.nextInt();
		scan.nextLine();

		Vehicle[] inventory = new Vehicle[size];
		
		for(int i = 0; i < size; i++){
			String line = scan.nextLine();
			Scanner sc = new Scanner(line);
			String code = sc.next();
			int mileage = sc.nextInt();
			Vehicle temp;
			if(code.charAt(0) == 'C'){
				int doors = sc.nextInt();
				char type = sc.next().charAt(0);
				temp = new Car(code, mileage, type, doors);
			}
			else if(code.charAt(0) == 'T'){
				String bed = sc.next();
				temp = new Truck(code, mileage, bed);
			}
			else{
				String bool = sc.next();
				boolean isElect = false;
				if(bool.equals("true")){
					isElect = true;
				}
				temp = new Van(code, mileage, isElect);
			}
			inventory[i] = temp;
		}
		
		Dealership dealer = new Dealership(name, inventory);

		System.out.println(dealer);

		System.out.println("\nSorted Data:\n");
		
		Sorter<Vehicle> sort = new Sorter<Vehicle>();
		Vehicle[] copy = dealer.getInventory();

		sort.selectionSort(copy);

		System.out.println(dealer.getName());
		
		for(Vehicle v : copy){
			System.out.println(v.getCode() + "\t" + form.format(v.calculatePrice()) + "\n");
		}

		while(scan.hasNext()){
			String searchCode = scan.nextLine();
			System.out.println("Vehicle " + ((dealer.search(searchCode) == null)?"not":"") + " found");
		}
	}
}