package myself;

import java.util.HashMap;

public class c03_13CopyListWithRandom {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node CopyListByHashMap(Node head) {
        HashMap<Node, Node> Copy = new HashMap<>();
        Node cur = head;
        //复制全部
        while (cur != null) {
            Copy.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        //通过复制的HasMap进行拷贝
        cur = head;
        while (cur != null) {
            //拷贝节点的下一个指针，等于原本节点的下一个拷贝节点
            Copy.get(cur).next = Copy.get(cur.next);
            Copy.get(cur).rand = Copy.get(cur.rand);
            cur = cur.next;
        }
        return Copy.get(head);
    }


    public static Node CopyListNoHashMap(Node head) {

        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);//指向拷贝副本
            cur.next.next = next;
            cur = cur.next.next;
        }
        //拷贝随机指针
        cur = head;
        while (cur != null) {
            //存在一种情况，末尾的随机指针指向为空，再引用空的下一个就会报错
            cur.next.rand = cur.rand != null ? cur.rand.next : null;//复制节点指向复制节点
            cur = cur.next.next;
        }
        //分离指针
        cur = head;
        Node copyHead = cur != null ? cur.next : null;//把拷贝节点的头结点提前存储起来
        Node curCopy = null;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next !=null?next.next:null;
            cur = next;
        }
        //错误代码，迭代递进就已经错了 1 2' 3????
//        while (cur != null) {
//            next = cur.next; //3'
//            cur.next = cur.next != null ? cur.next.next : null;
//            next.next = next.next != null ? next.next.next : null;
//            cur = next;
//        }
        return copyHead;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = CopyListByHashMap(head);
        printRandLinkedList(res1);
        res2 = CopyListNoHashMap(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = CopyListByHashMap(head);
        printRandLinkedList(res1);
        res2 = CopyListNoHashMap(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");
    }

}
