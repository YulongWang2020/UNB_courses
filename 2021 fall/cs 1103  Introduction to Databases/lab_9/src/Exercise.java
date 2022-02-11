public abstract class Exercise implements HealthTrackable{
    private String name;
    private int calorieRate;

    @Override
    public String getName() {
        return name;
    }

    public Exercise(String name, int calorieRate) {
        this.name = name;
        this.calorieRate = calorieRate;
    }

    @Override
    public double caloriesBurned(double hours) {
        return hours*calorieRate;
    }

}
