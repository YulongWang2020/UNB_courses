public class WordTree {
    private WordNode root;

    public WordTree(){

    }

    public void add(String wordIn){
        WordNode newNode = new WordNode(wordIn);
        if(root==null){
            root = newNode;
        }else{
            addhelper(root,newNode);
        }
    }

    private void addhelper(WordNode wordNode, WordNode newNode){
        if(newNode.word.compareTo(wordNode.word) < 0){
            if(wordNode.left == null){
                wordNode.left = newNode;
            }else{
                addhelper(wordNode.left,newNode);
            }
        }else{
            if(wordNode.right == null){
                wordNode.right = newNode;
            }else{
                addhelper(wordNode.right,newNode);
            }

        }
    }

    public int mystery(){
        int num = 0;
        if(root!=null){
            num = mysteryRec(root);
        }
        return num;
    }

    public int mysteryRec(WordNode current){
        int number = 0;

        if(current.left!=null){
            number = 1 + mysteryRec(current.left);
        }

        if(current.right!=null){
            System.out.println(current.right.word);
        }

        return number;
    }

    public void printTreeInReverseOrder(){
        printTreeInReverseOrder(root);
    }

    private void printTreeInReverseOrder(WordNode current){
        if (current == null) {
            return;
        }
        printTreeInReverseOrder(current.left);
        System.out.println(current.word);
        printTreeInReverseOrder(current.right);
    }

    class WordNode{
        public String word;
        public WordNode left;
        public WordNode right;

        public WordNode(String wordIn){
            word = wordIn;
            left = null;
            right = null;
        }
    }
}
