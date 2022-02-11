/**
 * @author Yulong Wang
 * @date 2021/10/10
 */
public class Car extends Vehicle{
    /**
     * The base price of car
     */
    private final static double defaultPrice = 10000.0;
    /**
     * The number of doors
     */
    private final int numDoor;
    /**
     * The type as hatchback (H) or trunk (T).
     */
    private final String type;

    /**
     * @param code The code id of the car
     * @param mileage The mileage of the car
     * @param numDoor The number of doors
     * @param type The type of the car.
     */
    public Car(String code, int mileage, int numDoor, String type) {
        super(code, mileage);
        this.numDoor = numDoor;
        this.type = type;
    }

    /**
     * Calculate the price of the car
     * @return double The price of the car
     */
    @Override
    public double calculatePrice() {
        double price = defaultPrice;
        if(numDoor == 4){
            price *= 1.05;
        }
        if(type.equals("H")){
            price += 1000;
        }
        return price;
    }
}
