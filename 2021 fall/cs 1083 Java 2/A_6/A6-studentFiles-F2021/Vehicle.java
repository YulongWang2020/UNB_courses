import java.text.NumberFormat;

/**
This class represents a vehicle.
@author Leah Bidlake
*/
public abstract class Vehicle implements Comparable<Vehicle>{

	/**
	The vehicle's code.
	*/
	private String code;
	
	/**
	The vehicle's mileage in km.
	*/
	private int mileage;
	
	/**
	Constructs a vehicle with a specific code and mileage.
	@param code the code of the vehicle.
	@param mileage the mileage of the vehicle.
	*/
	public Vehicle(String code, int mileage){
		this.code = code;
		this.mileage = mileage;
	}

	/**
	Returns the vehicle's code.
	@return returns the vehicle's code.
	*/
	public String getCode(){
		return code;
	}

	/**
	Returns the current mileage of the vehicle.
	@return returns the current mileage of the vehicle.
	*/
	public int getMileage(){
		return mileage;
	}

	/**
	Increases the mileage by the distance the vehicle was driven in the test drive (in km).
	@param distance the distance of the test drive in km.
	*/
	public void testDrive(int distance){
		mileage += distance;
	}

	/**
	Sorts vehicle alphabetically by type in the order cars, trucks, vans, and each type is 
	then sorted by the calculated price in ascending order (lowest to highest price).
	@param other the vehicle being compared to this vehicle.
	@return the result of the comparison.
	*/
	public int compareTo(Vehicle other){
		if(code.charAt(0) == other.code.charAt(0)){
			if(this.calculatePrice() - other.calculatePrice() > 0){
				return 1;
			}
			else{
				return -1;
			}
		}
		return this.code.compareTo(other.code);
	}

	/**
	Calculates the cost of the vehicle.
	@return the calcuated cost of the vehicle.
	*/
	public abstract double calculatePrice();

	/**
	Returns a formatted textual string containing information about the vehicle including
	code, mileage, and calculated price.
	@return textual string containing the code, mileage, and cost of the vehicle.
	*/
	public String toString(){
		NumberFormat form = NumberFormat.getCurrencyInstance();
		return code + "\t" + "Mileage: " + mileage + "km" +
				"\n\tCost: " + form.format(calculatePrice());
	}

}