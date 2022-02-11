import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class WordTreeDriver {
    public static void main(String[] args) {

        WordTree tree = new WordTree();
        tree.add("grand");
        tree.add("scald");
        tree.add("blank");
        tree.add("chart");
        tree.add("robot");
        tree.add("bark");
        tree.add("teeth");
        tree.add("ancient");

        System.out.println(tree.mystery());

        tree.printTreeInReverseOrder();

//        Queue<String> q = new LinkedList<String>();
//        Stack<String> s = new Stack<String>();
//        s.push("pudding");
//        s.push("pie");
//        s.push("cake");
//        q.add(s.pop());
//        q.add("ice-cream");
//        q.add(s.pop());
//        s.push("brownie");
//        s.push(q.poll());
//        q.poll();
//        q.add(s.peek());
//        s.push("fruit");
//        s.push("kiwi");
//        s.push(q.poll());
//        q.add(s.peek());
//        q.add(s.pop());
//
//        System.out.println(s.peek());



    }
}
