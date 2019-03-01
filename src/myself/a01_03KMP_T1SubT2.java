package myself;

public class a01_03KMP_T1SubT2 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isSubtree(Node n1, Node n2) {
        String s1 = treeSerialize(n1);
        String s2 = treeSerialize(n2);
        return getIndexOf(s1, s2) != -1 ? true : false;
    }

    public static String treeSerialize(Node head) {
        if (head == null) {
            return "#_";
        }
        String str = head.value + "_";
        str += treeSerialize(head.left);
        str += treeSerialize(head.right);
        return str;
    }

    public static int getIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < 0 || s1.length() < s2.length()) {
            return -1;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] next = getNextArray(chars2);
        int cur1 = 0;
        int cur2 = 0;
        while (cur1 < chars1.length && cur2 < chars2.length) {
            if (chars1[cur1] == chars2[cur2]) {
                cur1++;
                cur2++;
            } else {
                if (next[cur2] != -1) {
                    cur2 = next[cur2];
                } else {
                    cur1++;
                }
            }
        }
        return cur2 == chars2.length ? cur1 - cur2 : -1;
    }

    public static int[] getNextArray(char[] chars2) {
        int[] next = new int[chars2.length];
        next[0] = -1;
        next[1] = 0;
        int cur = 2;
        int jump = 0;
        while (cur < next.length) {
            if (chars2[cur - 1] == chars2[jump]) {
                next[cur++] = ++jump;
            } else {
                if (next[jump] != -1) {
                    jump = next[jump];
                } else {
                    next[cur++] = 0;
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(isSubtree(t1, t2));
    }

}





















