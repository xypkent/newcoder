package myself;

public class c03_07ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reverList(Node head) {

        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static DoubleNode reverseList(DoubleNode head) {

        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printLinkedList(Node head){
        System.out.println("Single Linked List: ");
        while(head != null){
            System.out.printf( head.value +  " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static void printDoubleLinkedList(DoubleNode head){
        System.out.println("Double Linked List: ");
        DoubleNode end = null;
        while(head != null){
            System.out.printf(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while(end != null){
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node SingleLinkedList = new Node(1);
        SingleLinkedList.next = new Node(2);
        SingleLinkedList.next.next = new Node(3);

        printLinkedList(SingleLinkedList);
        SingleLinkedList = reverList(SingleLinkedList);
        printLinkedList(SingleLinkedList);


        DoubleNode DoubleNodeLinke = new DoubleNode(1);
        DoubleNodeLinke.next = new DoubleNode(2);
        DoubleNodeLinke.next.next = new DoubleNode(3);
        DoubleNodeLinke.next.next.next = new DoubleNode(4);
        DoubleNodeLinke.next.last = DoubleNodeLinke;
        DoubleNodeLinke.next.next.last = DoubleNodeLinke.next;
        DoubleNodeLinke.next.next.next.last = DoubleNodeLinke.next.next;
        printDoubleLinkedList(DoubleNodeLinke);
        printDoubleLinkedList(reverseList(DoubleNodeLinke));
    }


}















