package myself;

import java.util.HashMap;

public class a04_02LongestSumSub {

    public static int countLongestSumSubArrayLength(int[] num, int aim) {
        if (num == null || num.length == 0 || aim == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i = 0; i != num.length; i++) {
            sum += num[i];
            int cur = sum - aim;
            if (map.containsKey(cur)) {
                max = Math.max(max, i - map.get(cur));
            }
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return max;
    }

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11) - 5;
        }
        return result;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateArray(20);
        printArray(arr);
        System.out.println(countLongestSumSubArrayLength(arr, 10));

    }
}












