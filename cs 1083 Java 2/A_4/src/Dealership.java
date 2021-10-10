import java.util.HashMap;

/**
 * @author Yulong Wang
 * @date 2021/10/10
 */
public class Dealership {
    /**
     * The name of the dealership
     */
    private final String name;
    /**
     * The list of vehicle own by the dealer
     */
    private Vehicle[] inventory = new Vehicle[0];
    /**
     * The dictionary contain all vehicle code own by the dealer as key.
     */
    private HashMap<String, Integer> map = new HashMap<String,Integer>();

    /**
     * @param name Dealership name
     * @param inventory List of vehicle own by the dealership
     */
    public Dealership(String name, Vehicle[] inventory) {
        this.name = name;
        for(Vehicle vehicle : inventory){
            if(vehicle != null){
                addVehicle(vehicle);
            }
        }
    }

    /**
     * Add the vehicle into the inventory.
     * @param vehicle Vehicle to be added
     * @return boolean If adding succeed.
     */
    public boolean addVehicle(Vehicle vehicle){
        Vehicle[] newList = new Vehicle[inventory.length+1];
        if(!map.containsKey(vehicle.getCode())){
            map.put(vehicle.getCode(),0);
            for(int i =0;i<inventory.length;i++){
                newList[i] = inventory[i];
            }
            newList[inventory.length] = vehicle;
            this.inventory = newList;
            return true;
        }
        return false;
    }

    /**
     * Get a copy of the inventory
     * @return {@link Vehicle[]}
     */
    public Vehicle[] getInventory() {
        return inventory.clone();
    }

    /**
     * Get the name of dealership
     * @return {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Find a vehicle in inventory
     * @param code The vehicle code to be searched
     * @return {@link String}
     */
    public String findInventory(String code) {
        for(int i=0;i<inventory.length;i++){
            if(inventory[i].getCode().equals(code)){
                return "vehicle found";
            }
        }
        return "vehicle not found";
    }

    /**
     * Convert the instance information to string
     * @return {@link String}
     */
    @Override
    public String toString() {
        String summary = name+"\n";
        for(Vehicle vehicle: inventory){
            summary+=vehicle.toString()+"\n";
        }
        return summary;
    }
}
