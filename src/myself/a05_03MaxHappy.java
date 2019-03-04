package myself;

import java.util.ArrayList;

public class a05_03MaxHappy {

    public static class Node {
        public int happy;
        public ArrayList<Node> childs;

        public Node(int happy) {
            this.happy = happy;
            childs = new ArrayList<>();
        }
    }

    public static class ReturnData {
        public int come;
        public int notCome;

        public ReturnData(int come, int notCome) {
            this.come = come;
            this.notCome = notCome;
        }
    }

    public static ReturnData process(Node head){
        int come = head.happy;
        int notCome = 0;

        for (Node node:head.childs){
            ReturnData rd = process(node);
            come += rd.come;
            notCome += Math.max(rd.come,rd.notCome);
        }
        return new ReturnData(come,notCome);

    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        ReturnData data = process(node1);
        System.out.println(Math.max(data.come, data.notCome));
    }
}


















