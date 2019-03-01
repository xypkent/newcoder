package myself;

public class c03_10PrintCommonPart {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){this.value = data;}
    }

    public static void printCommonPart(Node h1,Node h2){
        System.out.print("Common Part");
        while(h1 != null && h2 !=null){
            if(h1.value < h2.value){
                h1 = h1.next;
            }else if(h1.value > h2.value){
                h2 = h2.next;
            }else {
                System.out.printf(h1.value + " ");
                h1 = h1.next;
                h2 = h2.next;
            }
        }
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonPart(node1, node2);

    }

}
