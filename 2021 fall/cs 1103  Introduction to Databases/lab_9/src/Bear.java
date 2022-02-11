public class Bear {
    private Fish food;
    public Bear(){

    }

    public void setFood(Fish food) throws InsufficientFoodException {
        if(food.getWeight() < 25){
            throw new InsufficientFoodException();
        }else{
            this.food = food;
        }
    }
}
