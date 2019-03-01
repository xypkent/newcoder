package myself;

import java.util.LinkedList;

public class a02_01SlidingWidows {

    public static int[] getMaxWindows(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int cur = 0; cur != arr.length; cur++) {
            while (!linkedList.isEmpty() && arr[cur] >= arr[linkedList.peekLast()]) {
                linkedList.pollLast();
            }
            linkedList.add(cur);
            if (cur - w == linkedList.peekFirst()) {
                linkedList.pollFirst();
            }
            if (cur - w >= -1) {
                res[index++] = arr[linkedList.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={2,3,4,2,6,2,5,1};
        int[] maxWindow = getMaxWindows(arr, 3);
        for (int i = 0; i < maxWindow.length; i++) {
            System.out.print(maxWindow[i]+"-");
        }
    }

}
