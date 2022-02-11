public class Fish {
    private String type;
    private double weight;
    public Fish(String typeIn){
        type = typeIn;
        weight = 0.0;
    }

    public void addWeight(double weightToAdd) throws InvalidWeightException{
        if(weightToAdd<0){
            throw new InvalidWeightException();
        }else{
            weight+=weightToAdd;
        }
    }
    public String getType(){
        return type;
    }

    public double getWeight() {
        return weight;
    }
}
