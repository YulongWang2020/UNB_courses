interface Test1{
    void play();
}
public class test implements Test1 {
    @Override
    public void play() {
        System.out.println("123");
    }

    public void temp(){
        System.out.println("456");
    }

    public static void main(String[] args) {
        Test1 qwe = new test();
        qwe.play();
        qwe.temp();
    }
}