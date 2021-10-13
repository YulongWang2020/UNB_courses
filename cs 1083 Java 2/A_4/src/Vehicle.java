import java.text.NumberFormat;
import java.util.Locale;

/**
 * This class represents a vehicle.
 * @author Yulong Wang
 * @date 2021/10/10
 */
public abstract class Vehicle implements Comparable<Vehicle>{
    /**
     * Code that identically represent a car
     */
    private final String code;
    /**
     * The mileage of the vehicle
     */
    private int mileage;

    /**
     * @param code The code that identically represent a car.
     * @param mileage The mileage of the car
     */
    public Vehicle(String code, int mileage) {
        this.code = code;
        this.mileage = mileage;
    }

    /**
     * This method calculate the price of a car.
     * @return double The price of the car.
     */
    abstract double calculatePrice()
            ;

    /**
     * This method overwrite the compare to method.
     * @param other Another vehicle to be compared
     * @return int compare result 1 as bigger, 0 as equal, -1 as smaller.
     */
    @Override
    public int compareTo(Vehicle other){
        if(this.code.charAt(0) < other.code.charAt(0)){
            return -1;
        }else if(this.code.charAt(0) > other.code.charAt(0)){
            return 1;
        }else{
            if(this.calculatePrice() < other.calculatePrice()) {
                return -1;
            }else if(this.calculatePrice() > other.calculatePrice()){
                return 1;
            }else{
                return 0;
            }
        }
    }

    /**
     * Return the code of the vehicle
     * @return {@link String} The vehicle code
     */
    public String getCode(){
        return code;
    }

    /**
     * Return the mileage of the vehicle
     * @return int The vehicle mileage
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Add mileage to the vehicle
     * @param distance The mileage to be added
     */
    public void testDrive(int distance){
        if(distance>0){
            this.mileage += distance;
        }
    }

    /**
     * Convert instance information to a string
     * @return {@link String} string contains instance information
     */
    @Override
    public String toString() {
        Locale locale = new Locale("en", "CA");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return String.format("%-7s Mileage: %skm \n %7sCost: "+formatter.format(calculatePrice()),this.code,this.mileage,"");
    }
}
