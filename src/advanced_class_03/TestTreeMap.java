package advanced_class_03;

import java.util.TreeMap;

public class TestTreeMap {

    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(5,"xie");
        treeMap.put(10,"yu");
        treeMap.put(25,"peng");
        treeMap.put(15,"ni");
        treeMap.put(20,"hao");

        System.out.println(treeMap.get(10));

        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.firstKey());

        System.out.println(treeMap.ceilingKey(12));
        System.out.println(treeMap.floorKey(12));

    }
}
