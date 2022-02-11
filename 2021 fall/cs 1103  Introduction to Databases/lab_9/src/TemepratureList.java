import java.util.NoSuchElementException;

public class TemepratureList {
    private TemperatureNode head;

    public TemepratureList(){
        head = null;
    }

    public void add(double tempToAdd){
        if(head == null){
            head = new TemperatureNode(tempToAdd);
        }else{
            TemperatureNode curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = new TemperatureNode(tempToAdd);
        }
    }

    /**
     Moves the node containing the lowest temperature to the head of the list.
     @throws java.util.NoSuchElementException If there are no temperatures in the list.
     **/
    public void moveLowestTemperature() throws java.util.NoSuchElementException{
        if(head ==null){
            throw new NoSuchElementException();
        }else if(head.next != null){
            TemperatureNode min = head;
            TemperatureNode curr = head;
            while(curr.next!=null){
                if(curr.next.temp < min.temp){
                    min = curr;
                }
                curr = curr.next;
            }
            TemperatureNode truemin = min.next;
            min.next = min.next.next;

            truemin.next = head;
            head = truemin;
        }
    }

    class TemperatureNode{
        public double temp;
        public TemperatureNode next;

        public TemperatureNode(double tempIn){
            temp = tempIn;
            next = null;
        }
    }
    public static void main(String[] args) {
        TemepratureList nodelist = new TemepratureList();
        nodelist.moveLowestTemperature();
        System.out.println("123");
    }

}
