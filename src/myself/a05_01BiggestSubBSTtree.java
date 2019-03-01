package myself;

public class a05_01BiggestSubBSTtree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnData {
        public int maxSize;
        public Node maxNode;
        public int max;
        public int min;

        public ReturnData(int ms, Node mn, int max, int min) {
            maxSize = ms;
            maxNode = mn;
            this.max = max;
            this.min = min;
        }
    }

    public static ReturnData process(Node head){
        if (head == null){
            return new ReturnData(0,null,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        Node lTree =  head.left;
        ReturnData lReturnData = process(lTree);
        Node rTree =  head.right;
        ReturnData rReturnData = process(rTree);
        //最大的头
        Node maxNode = null ;
        //最大的数量
        int maxSize = 0;
        if (lReturnData.maxNode == lTree && rReturnData.maxNode == rTree
                && lReturnData.max < head.value && rReturnData.min > head.value){
            maxSize = lReturnData.maxSize + 1 + rReturnData.maxSize;
            maxNode = head;
        }

        if (maxSize == 0){
            if(lReturnData.maxSize>rReturnData.maxSize){
                maxNode = lReturnData.maxNode;
                maxSize = lReturnData.maxSize;
            }else{
                maxNode = rReturnData.maxNode;
                maxSize = rReturnData.maxSize;
            }
        }
        return new ReturnData(maxSize,maxNode,
                Math.max(Math.max(lReturnData.max, rReturnData.max),head.value),
                Math.min(Math.min(lReturnData.min,rReturnData.min),head.value));

    }


    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {

        Node head = new Node(6);
        head.left = new Node(1);
        head.left.left = new Node(0);
        head.left.right = new Node(3);
        head.right = new Node(12);
        head.right.left = new Node(10);
        head.right.left.left = new Node(4);
        head.right.left.left.left = new Node(2);
        head.right.left.left.right = new Node(5);
        head.right.left.right = new Node(14);
        head.right.left.right.left = new Node(11);
        head.right.left.right.right = new Node(15);
        head.right.right = new Node(13);
        head.right.right.left = new Node(20);
        head.right.right.right = new Node(16);

        printTree(head);
        Node bst = process(head).maxNode;
        printTree(bst);

    }

}





























