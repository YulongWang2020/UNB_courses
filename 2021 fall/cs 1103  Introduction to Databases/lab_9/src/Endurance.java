public class Endurance extends Exercise{
    public Endurance(String name, int calorieRate) {
        super(name, calorieRate);
    }

    @Override
    public double muscleBuild(double hours) {
        return hours*0.5;
    }
}
