package myself;

public class a03_04Morris {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //基本Morris   中序遍历
    public static void baseMorris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;

        while (cur != null) {
            if (cur.left != null) {//有左边，找左子树最右的节点
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {//第二次来到
                    mostRight.right = null;
                    System.out.print(cur.value + " ");
                    cur = cur.right;
                }
            } else {//没有左子树，直接向右
                System.out.print(cur.value + " ");
                cur = cur.right;
            }
        }
    }

    public static void preMorris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;

        while (cur != null) {
            if (cur.left != null) {//有左边，找左子树最右的节点
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    System.out.print(cur.value + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                } else {//第二次来到
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {//没有左子树，直接向右
                System.out.print(cur.value + " ");
                cur = cur.right;
            }
        }
    }

    public static void posMorris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;

        while (cur != null) {
            if (cur.left != null) {//有左边，找左子树最右的节点
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {//第二次来到
                    mostRight.right = null;
                    //逆序打印右边界
                    printEdge(cur.left);//逆序打印左子树右边界
                    cur = cur.right;
                }
            } else {//没有左子树，直接向右
                cur = cur.right;
            }
        }
    }

    private static void printEdge(Node head) {
        Node tail = reverse(head);
        Node cur = tail;
        while (cur != null) {
            System.out.printf(cur.value + " ");
            cur = cur.right;
        }
        reverse(tail);
    }

    private static Node reverse(Node cur) {
        Node pre = null;
        while (cur != null) {
            Node next = cur.right;
            cur.right = pre;
            pre = cur;
            next.right = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        baseMorris(head);
        System.out.println();
        preMorris(head);
    }
}






















