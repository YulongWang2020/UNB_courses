/**
 * @author Yulong Wang
 * @date 2021/10/10
 */
public class Van extends Vehicle{
    /**
     * The base price of a van
     */
    private final static double defaultPrice = 25000.0;
    /**
     * If the van has an electrical door closure
     */
    private final Boolean eDoorClosure;

    /**
     * @param code The code id of the van
     * @param mileage The mileage of the van
     * @param eDoorClosure If the van has an electrical door closure
     */
    public Van(String code, int mileage, Boolean eDoorClosure) {
        super(code, mileage);
        this.eDoorClosure = eDoorClosure;
    }

    /**
     * Calculate the price of the van
     * @return double The price of the van
     */
    @Override
    public double calculatePrice() {
        if(eDoorClosure){
            return defaultPrice*1.15;
        }else{
            return defaultPrice;
        }
    }
}
