package myself;

public class c04_04IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnData{
        public boolean isBalance;
        public int level;

        public ReturnData(boolean isBalance, int level) {
            this.isBalance = isBalance;
            this.level = level;
        }
    }

    public static ReturnData process(Node head){
        if(head == null){
            return new ReturnData(true,0);
        }
        //如果左子树或者右子树返回了他们不是平衡的，那总体也不会是平衡的
        ReturnData lRData = process(head.left);
        if(!lRData.isBalance){
            return new ReturnData(true,0);
        }
        ReturnData rRData = process(head.right);
        if(!rRData.isBalance){
            return new ReturnData(true,0);
        }
        if(Math.abs(lRData.level - rRData.level) > 1){
            return new ReturnData(true,0);
        }
        return new ReturnData(true,Math.max(lRData.level,rRData.level)+1);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(process(head).isBalance);

    }


}












