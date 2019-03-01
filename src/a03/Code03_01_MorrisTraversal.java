<<<<<<< HEAD
package a03;
=======
package advanced_class_03;
>>>>>>> 0f1e08fe64ad7f74b41cfd8622839e9577de4cd2

public class Code03_01_MorrisTraversal {

    //帮助理解Morris遍历
    public static void process(Node head) {
        if (head == null) {
            return;
        }
        // 1
        //System.out.println(head.value);
        process(head.left);
        // 2
        //System.out.println(head.value);
        process(head.right);
        // 3
        //System.out.println(head.value);
    }


    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    //中序遍历
    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {//如果左孩子不等于空
                //找到最右的节点，排除了null和cur的情况，能一直找下去
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }
    //先序遍历
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.print(cur.value + " ");
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {//当前节点没有左子树的时候，直接打印(中,左)再往右
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }
    //后序遍历
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {//第二次来的自己的时候
                    cur2.right = null;
                    printEdge(cur1.left);//逆序打印左子树右边界
                }
            }
            cur1 = cur1.right;
        }
        printEdge(head);
        System.out.println();
    }

    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
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
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        printTree(head);
        morrisIn(head);
        morrisPre(head);
        morrisPos(head);
        printTree(head);
    }

}
