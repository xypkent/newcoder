package myself;

import java.util.Arrays;
import java.util.Comparator;

public class c07_02LowestLexicography {

    public static class MyCompare implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs,new MyCompare());
        String lowestString = "";
        for (String s: strs) {
            lowestString += s;
        }
        return lowestString;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));
    }

}
