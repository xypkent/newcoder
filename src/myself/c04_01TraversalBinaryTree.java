package myself;

import java.util.Stack;

public class c04_01TraversalBinaryTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrderTraversal(Node head) {
        if (head == null) return;

        System.out.print(head.value + " ");
        preOrderTraversal(head.left);
        preOrderTraversal(head.right);
    }

    public static void infixOrderTraversal(Node head) {
        if (head == null) return;

        infixOrderTraversal(head.left);
        System.out.print(head.value + " ");
        infixOrderTraversal(head.right);
    }

    public static void postOrderTraversal(Node head) {
        if (head == null) return;

        postOrderTraversal(head.left);
        postOrderTraversal(head.right);
        System.out.print(head.value + " ");
    }

    public static void preOrderUnRecur(Node head) {
        System.out.printf("pre-order-unrecur: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.printf(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        //啥都没有
        System.out.printf("");
    }

    public static void inOrderUnRecur(Node head) {
        System.out.printf("in-order-unrecur: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.printf(head.value + " ");
                    head = head.right;
                }
            }
        }
        //啥都没有
        System.out.printf(" ");
    }

    public static void posOrderUnRecur(Node head){
        System.out.printf("pos-order-unrecur: ");
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        if(head!=null){
            stack1.push(head);
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if(head.left != null){
                    stack1.push(head.left);
                }
                if(head.right != null){
                    stack1.push(head.right);
                }
            }
            while(!stack2.isEmpty()){
                System.out.printf(stack2.pop().value + " ");
            }

        }
        //啥都没有！
        System.out.printf(" ");
    }



}

















