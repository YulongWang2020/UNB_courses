/**
This class represents a dealership.
@author Leah Bidlake
*/
public class Dealership{

	/**
	The inventory of the dealership.
	*/
	private Vehicle[] inventory;
	
	/**
	The name of the dealership.
	*/
	private String name;
	
	/**
	Creates a Dealership object.
	@param name the name of the dealership.
	@param inventory the list of vehicles in the inventory.
	*/
	public Dealership(String name, Vehicle[] inventory){
		this.name = name;
		this.inventory = inventory;
	}

	/**
	Returns a copy of the vehicle inventory.
	@return a copy of the vehicle inventory.
	*/
	public Vehicle[] getInventory(){
		Vehicle[] temp = new Vehicle[inventory.length];
		for(int i = 0; i < inventory.length; i++){
			temp[i] = inventory[i];
		}
		return temp;
	}

	/**
	Returns the target vehicle.
	@param code the code of the vehicle to search for.
	@return the target vehicle or null if not found.
	*/
	public Vehicle search(String code){
		Vehicle found = null;
		for(int i = 0; i < inventory.length && found == null; i++){
			if(inventory[i].getCode().equals(code)){
				found = inventory[i];	
			}
		}
		return found;
	}

	/**
	Returns the name of the dealership.
	@return the name of the dealership.
	*/
	public String getName(){
		return name;
	}

	/**
	Returns a formatted textual string with the dealership information.
	@return a formatted textual string.
	*/
	public String toString(){
		String result = name + "\n";
		for(int i = 0; i < inventory.length; i++){
			result += inventory[i] + "\n";
		}
		return result;
	}
}