/**
 * @author Yulong Wang
 * @date 2021/10/10
 */
public class Truck extends Vehicle{
    /**
     * The base price of the truck
     */
    private final static double defaultPrice = 50000.0;
    /**
     * The bed size of the truck: standard, short, or long.
     */
    private final String bedSize;

    /**
     * @param code The code id of the truck
     * @param mileage The mileage of the truck
     * @param bedSize The bed size of the truck
     */
    public Truck(String code, int mileage, String bedSize) {
        super(code, mileage);
        this.bedSize = bedSize;
    }

    /**
     * Calculate the price of the truck
     * @return double The price of the truck
     */
    @Override
    public double calculatePrice() {
        switch (this.bedSize){
            case "short":
                return defaultPrice*0.9;
            case "long":
                return defaultPrice*1.1;
            default:
                return defaultPrice;
        }
    }
}
