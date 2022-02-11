import java.util.NoSuchElementException;

/**
 * Represent a doubly-linked list made up of students
 * @author Yulong Wang
 * @date 2021/11/30
 */
public class ClassList {
    /**
     * The last node in the list
     */
    private StudentNode end;
    /**
     * The first node in the list
     */
    private StudentNode front;
    /**
     * the current size of the list
     */
    private int size;

    /**
     * Contructor
     */
    public ClassList() {
    }

    /**
     * Add a new node representing a specified student at the appropriate position in the list.
     * @param studentIn Student to be added
     */
    public void add(Student studentIn){
        size +=1;
        if(front == null){
            StudentNode res = new StudentNode(studentIn);
            front = res;
            end = res;
            return;
        }
        StudentNode temp = front;
        while(temp!= null){
            if(temp.data.compareTo(studentIn) > 0){
                if(temp == front){
                    StudentNode res = new StudentNode(studentIn);
                    front.prev = res;
                    res.next = front;
                    front = res;
                    return;
                }else{
                    temp = temp.prev;
                }
                break;
            }
            temp = temp.next;
        };
        if(temp == front && temp.data.compareTo(studentIn) > 0){
            StudentNode res = new StudentNode(studentIn);
            front.prev = res;
            res.next = front;
            front = res;
            return;
        }
        if(temp!=null){
            StudentNode res = new StudentNode(studentIn);
            temp.next.prev = res;
            res.next = temp.next;
            temp.next = res;
            res.prev = temp;
        }else{
            StudentNode res = new StudentNode(studentIn);
            end.next = res;
            res.prev = end;
            end = res;
        }
    }

    /**
     * return the number of student in the list
     * @return int the number of students
     */
    public int getNumStudents(){
        return size;
    }

    /**
     * creates and return an array containing all of the students in this list,
     * stored in reverse order in the array
     * @return {@link Student[]}
     */
    public Student[] getReversedList(){
        Student[] reversedList = new Student[size];
        StudentNode temp = end;
        for(int i=0;i<size;i++){
            reversedList[i] = temp.data;
            temp = temp.prev;
        }
        return reversedList;
    }

    /**
     * remove from the list the node containing the specified student
     * @param studentOut the student to be removed
     * @throws NoSuchElementException
     */
    public void remove(Student studentOut) throws NoSuchElementException {
        StudentNode temp = front;
        while(temp != null){
            if(temp.data.compareTo(studentOut) != 0){
                temp = temp.next;
            }else {
                if(temp.prev!= null){
                    temp.prev.next = temp.next;
                    if(temp.next != null){
                        temp.next.prev = temp.prev;
                    }else{
                        end = temp.prev;
                    }
                }else{
                    if(temp.next != null){
                        front.next.prev = null;
                        front = front.next;
                    }else{
                        front = null;
                        end = null;
                    }
                }
                size-=1;
                return;
            }
        }
        throw new NoSuchElementException("Student not found");
    }

    /**
     * return a string of the content of the list in order
     * @return {@link String}
     */
    @Override
    public String toString() {
        StudentNode temp = front;
        String res = "";
        while(temp!= null){
            res += temp.data.toString() + "\n";
            temp = temp.next;
        }
        return res;
    }

    /**
     * An inner class that represents a node in the class
     * @author Yulong Wang
     * @date 2021/11/30
     */
    private class StudentNode{
        /**
         * the student refrenced by this node
         */
        private Student data;
        /**
         * next node
         */
        private StudentNode next;
        /**
         * previous node
         */
        private StudentNode prev;

        /**
         * constructor
         * @param dataIn
         */
        public StudentNode(Student dataIn) {
            this.data = dataIn;
            this.next = null;
            this.prev = null;
        }
    }
}
