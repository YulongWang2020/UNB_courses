public class Strength extends Exercise{
    public Strength(String name, int calorieRate) {
        super(name, calorieRate);
    }

    @Override
    public double muscleBuild(double hours) {
        return hours*0.75;
    }
}
