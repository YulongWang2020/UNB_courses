/**
Represents a truck.
@author Leah Bidlake
*/
public class Truck extends Vehicle{
	
	/**
	The bed size of the truck.
	*/
	private String bed;
	
	/**
	Create a Truck object.
	@param code the code for the truck.
	@param mileage the initial mileage on the truck.
	@param bed the size of the truck bed.
	*/
	public Truck(String code, int mileage, String bed){
		super(code, mileage);
		this.bed = bed;
	}

	/**
	Calculates the cost of the vehicle.
	@return the calcuated cost of the vehicle.
	*/
	public double calculatePrice(){
		double cost = 50000;
		if(bed.equals("short")){
			cost = cost * 0.9;
		}
		else if(bed.equals("long")){
			cost = cost * 1.1;
		}
		return cost;
	}

}