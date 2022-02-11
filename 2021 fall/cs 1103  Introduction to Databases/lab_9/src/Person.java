public class Person implements HealthTrackable {
    private String name;
    private int weight;
    private int metabolicRate;

    public Person(String name, int weight, int metabolicRate) {
        this.name = name;
        this.weight = weight;
        this.metabolicRate = metabolicRate;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double caloriesBurned(double hours){
        return ((weight*0.05 + metabolicRate)*hours);
    }

    public double muscleBuild(double hours){
        return 0.01*hours;
    }

    public String getName(){
        return name;
    }
}
