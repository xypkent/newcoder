package a02;

import java.util.LinkedList;

public class Code_03_ALLLessNumSubArray {

    //暴力的方法o(n^3),没必要看了
    public static int getNum1(int[] array,int num) {
        int count = 0;
        for (int start = 0; start != array.length; start++) {
            for (int end = start; end != start; end++) {
                if (isValid(array,start,end,num))
                    count++;
            }
        }
        return count;
    }

    public static boolean isValid(int[] array, int s, int e, int num) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        for (int n = s; n != e; n++) {//找出最大最小
            MAX = Math.max(array[n], MAX);
            MIN = Math.min(array[n], MIN);
        }
        return MAX - MIN <= num;
    }


    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //准备最大/小值的更新结构
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int L = 0;
        int R = 0;
        int res = 0;
        while (L < arr.length) {
            while (R < arr.length) {//R扩到不能再扩，停
                //最小值结构更新
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);
                ////最大值结构更新
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.addLast(R);
                //不达标
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                R++;
            }
            //L向前推动，双端队列进行调整
            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
            res += R - L;
            L++;//换一个开头
        }
        return res;
    }

    public static void main(String[] args) {
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
>>>>>>> 0f1e08fe64ad7f74b41cfd8622839e9577de4cd2
        int[] arr_test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int num_test = 4;
        int res_test;
        res_test = getNum(arr_test, num_test);
        System.out.printf("res = %d", res_test);
    }


}
