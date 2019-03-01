package myself;

public class a05_02LongestSumSubArrayList {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value){
            this.value = value;
        }
    }

    public static class ReturnData{
        public int maxDistance;
        public int h;
        public ReturnData(int m,int h){
            maxDistance = m;
            this.h = h;
        }
    }

    public static ReturnData process(Node head){
        if (head == null){
            return new ReturnData(0,0);
        }
        ReturnData lData = process(head.left);
        ReturnData rData = process(head.right);
        int maxDistance = 0;
        maxDistance = Math.max(lData.maxDistance,rData.maxDistance);
        maxDistance = Math.max(lData.h + rData.h + 1,maxDistance);

        return new ReturnData(maxDistance,Math.max(lData.h,rData.h)+1);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(process(head1).maxDistance);

        Node head2 = new Node(1);
        head2.left = new Node(2);
        head2.right = new Node(3);
        head2.right.left = new Node(4);
        head2.right.right = new Node(5);
        head2.right.left.left = new Node(6);
        head2.right.right.right = new Node(7);
        head2.right.left.left.left = new Node(8);
        head2.right.right.right.right = new Node(9);
        System.out.println(process(head2).maxDistance);
    }

}























