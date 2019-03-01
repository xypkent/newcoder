package myself;

import java.util.HashMap;
import java.util.List;

public class c05_05UnionFind {

    public static class Node {
        // whatever you like
    }

    public static class UnionFind {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionFind(List<Node> nodes) {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
            createUnionFindSet(nodes);
        }

        private void createUnionFindSet(List<Node> nodes) {
            //初始化操作
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        private Node findHead(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node ahead = findHead(a);
            Node bhead = findHead(a);
            if(ahead != bhead){
                Integer asize = sizeMap.get(ahead);
                Integer bsize = sizeMap.get(bhead);
                if(asize <= bsize){
                    fatherMap.put(ahead,bhead);
                    sizeMap.put(bhead,asize+bsize);
                }else{
                    fatherMap.put(bhead,ahead);
                    sizeMap.put(ahead,asize+bsize);
                }
            }
        }


    }


}












