public class Flexibility extends Exercise{
    public Flexibility(String name, int calorieRate) {
        super(name, calorieRate);
    }

    @Override
    public double muscleBuild(double hours) {
        return hours*0.25;
    }
}
