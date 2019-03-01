package myself;

import java.util.HashMap;
import java.util.Map;

public class c05_01HashMap {



    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();

        map.put("A","1");
        map.put("B","2");
        map.put("B","3");
        map.put("C","3");

        for (String key: map.keySet()) {
            System.out.printf(key +  " ");
        }
        System.out.printf(map.containsKey("C") + " ");
        System.out.println("=========================");
        map.clear();
        map.put("B","2");

        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.printf(entry.getKey() + " ");
            System.out.printf(entry.getValue() + " ");
        }

    }



}
