package myself;

import java.util.Stack;

public class c03_11IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //need n extra space
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node refer = head;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (refer != null) {
            if (refer.value != stack.pop().value) {
                return false;
            }
            refer = refer.next;
        }

        return true;
    }

    public static boolean isPalindrome2(Node head) {
        //啥都没有肯定是回文..
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //at this moment slow指针在中间
        // 把中间往后的压栈
        Stack<Node> assist = new Stack<Node>();
        slow = slow.next;
        while (slow != null) {
            //1 2 3 2 1   存入 2 1
            //1 2 3 3 2 1 存入 3 2 1
            assist.push(slow);
            slow = slow.next;
        }
        //对比
        while (!assist.isEmpty()) {
            if (head.value == assist.pop().value) {
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) return true;

        //找到中间点
        Node n2 = head, n1 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        //变换指向
        n2 = n1.next;//对中点进行操作前，先保存下一个节点的位置
        Node n3 = null;//中间商
        n1.next = null;//把中点置空
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        //变换后，n1指向最后的节点
        n3 = n1;//尾部
        n2 = head;//头部
        boolean result = true;
        while(n2 != null&& n3!=null){
            if(n2.value == n3.value){
                n2 =n2.next;
                n3 =n3.next;
            }else{
                result = false;
                break;
            }
        }
        //调整回去
        n3 = n1.next;//n3还是中间商
        n1.next = null;
        while(n3 != null){
            n2 = n3.next;
            n3.next = n1;
            n1 = n3;
            n3 = n2;
        }

        return result;
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

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");


        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }

}




















