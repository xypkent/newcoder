package myself;

public class c04_06CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            value = data;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        //树高
        int th = mostLeftLevel(head);
        return calculate(head, 1, th);
    }

    private static int calculate(Node node, int l, int th) {
        if (l == th){
            return 1;
        }

        //如果右子树的高度等于总高度
        if ((mostLeftLevel(node.right)+l)==th){
            return (1 << (th - l)) + calculate(node.right,l+1,th);
        }else{
            return (1 << (th - l - 1 )) + calculate(node.left,l+1,th);
        }
    }

    private static int mostLeftLevel(Node node) {
        int level = 0;
        while (node != null) {
            level++;
            node = node.left;
        }
        return level;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));
    }


}

















