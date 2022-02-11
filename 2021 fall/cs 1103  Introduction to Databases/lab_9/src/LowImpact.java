public class LowImpact extends Endurance{
    public LowImpact(String name, int calorieRate) {
        super(name, calorieRate);
    }

    @Override
    public double muscleBuild(double hours) {
        return hours*0.3;
    }
}
