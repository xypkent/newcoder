package myself;

import java.util.LinkedList;
import java.util.Queue;

public class c04_03SerializeAndReconstruct {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static String serializeByPre(Node head){
        if(head == null){
            return "#_";
        }

        String res = head.value + "_";
        res += serializeByPre(head.left);
        res += serializeByPre(head.right);
        return res;
    }

    public static Node reconstructByPreStrig(String res){
        String[] nodes = res.split("_");
        Queue<String> queue = new LinkedList<String>();

        for (int i=0;i<nodes.length;i++){
            queue.offer(nodes[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if(value.equals("#")) return null;

        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }


}





















