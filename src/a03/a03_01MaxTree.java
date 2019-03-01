package a03;

import java.util.HashMap;
import java.util.Stack;

public class a03_01MaxTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getMaxTree(int[] nodes) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> lLarge = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> rLarge = new HashMap<Integer, Integer>();

        for (int i = 0; i != nodes.length; i++) {
            while (!stack.isEmpty() && nodes[i] > nodes[stack.peek()]) {
                int index = stack.pop();
                //谁让它弹出谁就是右边比他大的
                rLarge.put(index, i);
                //再通过栈来设置左边的情况
                if (stack.isEmpty()) {
                    lLarge.put(index, null);
                } else {
                    lLarge.put(index, stack.peek());
                }
            }
            stack.push(i);
        }
        //把栈里面剩下的元素处理下
        while (!stack.isEmpty()) {
            int index = stack.pop();
            rLarge.put(index, null);
            if (stack.isEmpty()) {
                lLarge.put(index, null);
            } else {
                lLarge.put(index, stack.peek());
            }
        }

        //形成Node数组
        Node[] treeNodes = new Node[nodes.length];
        for (int i = 0; i != nodes.length; i++) {
            treeNodes[i] = new Node(nodes[i]);
        }
        //建树
        Node head = null;
        for (int i = 0; i != nodes.length; i++) {
            Integer lLargeIndex = lLarge.get(i);
            Integer rLargeIndex = rLarge.get(i);
            if (lLargeIndex == null && rLargeIndex == null) {
                head = treeNodes[i];
            } else if (lLargeIndex == null) {
                if (treeNodes[rLargeIndex].left == null) {
                    treeNodes[rLargeIndex].left = treeNodes[i];
                } else {
                    treeNodes[rLargeIndex].right = treeNodes[i];
                }
            } else if (rLargeIndex == null) {
                if (treeNodes[lLargeIndex].left == null) {
                    treeNodes[lLargeIndex].left = treeNodes[i];
                } else {
                    treeNodes[lLargeIndex].right = treeNodes[i];
                }
            } else {//对比左右大小
                Node parent = nodes[lLargeIndex] > nodes[rLargeIndex] ? treeNodes[rLargeIndex] : treeNodes[lLargeIndex];
                if (parent.left == null) {
                    parent.left = treeNodes[i];
                } else {
                    parent.right = treeNodes[i];
                }
            }
        }
        return head;
    }

    //二叉树的先序遍历
    public static void printPreOrder(Node head) {
        if (head == null) { return; }
        System.out.print(head.value + " ");
        printPreOrder(head.left);  //递归调用遍历二叉树
        printPreOrder(head.right);
    }

    //二叉树的中序遍历
    public static void printInOrder(Node head) {
        if (head == null) { return; }
        printInOrder(head.left);
        System.out.print(head.value + " ");
        printInOrder(head.right);
    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        Node head = getMaxTree(arr);
        printPreOrder(head);
        System.out.println();
        printInOrder(head);
    }


}
























