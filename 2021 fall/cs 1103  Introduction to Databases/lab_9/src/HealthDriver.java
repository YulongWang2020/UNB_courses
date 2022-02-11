public class HealthDriver {
    public static void main(String[] args) {
        Exercise f = new Flexibility("Yoga", 150);
        Endurance e = new LowImpact("Water aerobics", 300);
        int weight =160;
        Person p = new Person("Jenna", 175, 45);

        HealthTrackable[] record = new HealthTrackable[5];

        record[0] = new Endurance("Running", 350);
        record[1] = f;
        record[2] = new Strength("Rock Climbing", 400);
        record[3] = e;
        record[4] = p;

        p.setWeight(weight);

        double[] time = {3,2,1,2,1.5};

        for(int i=0; i< record.length;i++){
            System.out.println(record[i].getName() + "\t" +
                    record[i].caloriesBurned(time[i]) +
                    "\t" + record[i].muscleBuild(time[i]));
        }
    }
}
