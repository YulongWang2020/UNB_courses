/**
Represents a van.
@author Leah Bidlake
*/
public class Van extends Vehicle{
	
	/**
	Electric door closure if true, manual if false.
	*/
	private boolean isElectric;
	
	/**Creates a Van object.
	@param code the code for the van.
	@param mileage the initial mileage on the van.
	@param isElectric the door closure type.
	*/
	public Van(String code, int mileage, boolean isElectric){
		super(code, mileage);
		this.isElectric = isElectric;
	}

	/**
	Calculates the cost of the vehicle.
	@return the calcuated cost of the vehicle.
	*/
	public double calculatePrice(){
		double cost = 25000;
		if(isElectric){
			cost = cost * 1.15;
		}
		
		return cost;
	}

}