package myself;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class a04_01Building_Outline {

    public static class Detail {
        public int situation;
        public int height;
        public boolean isUp;

        public Detail(int s, int h, boolean b) {
            situation = s;
            height = h;
            isUp = b;
        }
    }

    public static class DetailComparator implements Comparator<Detail> {
        public int compare(Detail a, Detail b) {
            if (a.situation == b.situation) {
                if (a.isUp) return -1;
                if (b.isUp) return -1;
            }
            return a.situation - b.situation;
        }
    }

    public static ArrayList<ArrayList<Integer>> getBuildingOutLine(int[][] data) {
        ArrayList<Detail> list = new ArrayList<>();
        for (int i = 0; i != data.length; i++) {
            list.add(new Detail(data[i][0], data[i][2], true));
            list.add(new Detail(data[i][1], data[i][2], false));
        }
        list.sort(new DetailComparator());

        TreeMap<Integer, Integer> htMap = new TreeMap<>();
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();
        for (Detail d : list) {
            if (d.isUp) {
                if (htMap.containsKey(d.height)) {
                    htMap.put(d.height, htMap.get(d.height) + 1);
                } else {
                    htMap.put(d.height, 1);
                }
            } else {
                if (htMap.containsKey(d.height)) {
                    if (htMap.get(d.height) == 1) {
                        htMap.remove(d.height);
                    } else
                        htMap.put(d.height, htMap.get(d.height) - 1);
                }
            }
            //收集位置高度
            if (htMap.isEmpty()) {
                pmMap.put(d.situation, 0);
            } else {
                pmMap.put(d.situation, htMap.lastKey());
            }
        }
        //统计答案
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;
        for (Entry<Integer, Integer> entry : pmMap.entrySet()) {
            int curSituation = entry.getKey();
            int curMaxHeight = entry.getValue();
            if (height != curMaxHeight) {
                if (height != 0) {
                    ArrayList resList = new ArrayList();
                    resList.add(start);
                    resList.add(curSituation);
                    resList.add(height);
                    res.add(resList);
                }
                start = curSituation;
                height = curMaxHeight;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1, 3, 3}, {2, 4, 4}, {5, 6, 1}
        };

        ArrayList<ArrayList<Integer>> buildingOutLine = getBuildingOutLine(test);

        for (ArrayList<Integer> list:buildingOutLine){
            for (Integer i:list) {
                System.out.printf( i + " ");
            }
            System.out.println();
        }
    }


}




















