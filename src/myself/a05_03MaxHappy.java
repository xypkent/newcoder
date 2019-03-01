package myself;

import java.util.ArrayList;

public class a05_03MaxHappy {

    public static class Node {
        public int happy;
        public ArrayList<Node> child;

        public Node(int happy) {
            this.happy = happy;
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

    }
}


















