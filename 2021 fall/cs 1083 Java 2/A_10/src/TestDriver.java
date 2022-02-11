import java.util.NoSuchElementException;

/**
 * test driver for the ClassList class
 * @author Yulong Wang
 * @date 2021/11/30
 */
public class TestDriver {
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        ClassList classList = new ClassList();

        classList.add(new Student("a","b",1));
        classList.add(new Student("c","d",2));
        System.out.println(classList);

        System.out.println("add to the front:");
        classList.add(new Student("a","a",3));
        System.out.println(classList);

        System.out.println("add to the end:");
        classList.add(new Student("d","d",4));
        System.out.println(classList);

        System.out.println("add to the middle:");
        classList.add(new Student("c","b",5));
        System.out.println(classList);

        System.out.println("add same student:");
        classList.add(new Student("a","b",1));
        System.out.println(classList);
        
        System.out.println("reversed linked list");
        Student[] temp = classList.getReversedList();
        for(Student each : temp){
            System.out.println(each);
        }

        System.out.println("\nOriginal Linked List: ");
        System.out.println(classList);

        System.out.print("Length: ");
        System.out.println(classList.getNumStudents()+"\n");

        System.out.println("remove student not exists: d,c (12)");
        try{
            classList.remove(new Student("c","d",12));
            System.out.println(classList);
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }


        System.out.println("after remove student from the front:");
        classList.remove(new Student("a","a",3));
        System.out.println(classList);

        System.out.println("after remove student from the end:");
        classList.remove(new Student("d","d",4));
        System.out.println(classList);

        System.out.print("Length: ");
        System.out.println(classList.getNumStudents()+"\n");

        System.out.println("after remove student from the middle:");
        classList.remove(new Student("a","b",1));
        System.out.println(classList);

        System.out.println("after remove student from the front:");
        classList.remove(new Student("a","b",1));
        System.out.println(classList);

        System.out.println("after remove student from the end/front:");
        classList.remove(new Student("c","d",2));
        System.out.println(classList);

        System.out.print("Length: ");
        System.out.println(classList.getNumStudents()+"\n");
    }
}
