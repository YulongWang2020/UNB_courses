public class AbsoluteProgression extends Progression{
    private long previous;
    AbsoluteProgression(long first, long second){
        current = second;
        first = previous;
    }

    AbsoluteProgression(){
        current = 200;
        previous = 2;
    }

    @Override
    protected void advance(){
        long temp = current;
        current =Math.abs(current - previous);
        previous = temp;
    }
    @Override
    public void printProgression(int n) {
        System.out.print(previous + " ");
        super.printProgression(n-1);
    }

    public static void main(String[] args) {
        AbsoluteProgression temp = new AbsoluteProgression();
        temp.printProgression(5);
    }


}