package myself;

import java.util.LinkedList;

public class a02_02AllLessNumSubArray {

    public static int countAllLessSubArray(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> maxlist = new LinkedList<Integer>();
        LinkedList<Integer> minlist = new LinkedList<Integer>();
        int L = 0;
        int R = 0;
        int count = 0;
        while (L < arr.length) {
            while (R < arr.length) {
                //判断前面的是否弹出
                while (!maxlist.isEmpty() && arr[R] >= arr[maxlist.peekLast()]) {
                    maxlist.pollLast();
                }
                while (!minlist.isEmpty() && arr[R] <= arr[minlist.peekLast()]) {
                    minlist.pollLast();
                }
                maxlist.add(R);
                minlist.add(R);
                //不满足条件
                if (arr[maxlist.getFirst()] - arr[minlist.getFirst()] > num) {
                    break;
                }
                R++;
            }
            //L向前推动，双端队列进行调整
            if (minlist.peekFirst() == L){
                minlist.pollFirst();
            }
            if (maxlist.peekFirst() == L){
                maxlist.pollFirst();
            }
            count += R - L;
            L++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr_test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int num_test = 1;
        int res_test;
        res_test = countAllLessSubArray(arr_test, num_test);
        System.out.printf("res = %d", res_test);
    }
}
