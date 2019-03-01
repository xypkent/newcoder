package myself;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class c04_05IsBSTAndCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        Stack<Node> stack = new Stack<Node>();
        //首先有一个很小的数做初始值
        int flag = Integer.MIN_VALUE;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.value < flag) {
                    return false;//不是升序就不是搜索二叉树
                }
                head = head.right;
            }
        }
        return true;
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();

        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            l = node.left;
            r = node.right;
            if ((leaf && !(l == null && r == null)) || (l == null && r != null)) {
                return false;
            }
//            System.out.printf(node.value + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else {//如果右子树为空，左子树不为空，接下来的都要是叶子节点
                leaf = true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        System.out.printf(isBST(head) + "");
        System.out.printf(isCBT(head) + "");

    }

}











