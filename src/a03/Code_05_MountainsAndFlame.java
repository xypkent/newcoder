package a03;

import java.util.Scanner;
import java.util.Stack;

public class Code_05_MountainsAndFlame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(communications(arr));
        }
        in.close();
    }

    public static class Pair {
        public int value;
        public int times;

        public Pair(int v) {
            this.value = v;
            this.times = 1;
        }
    }

    private static long communications(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {//获得最大值的下标
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        int value = arr[maxIndex];//最大值
        int index = nextIndex(size, maxIndex);//最大值位置的下一个
        long res = 0L;//能互相看见的山峰数
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(new Pair(value));//以最大值为底
        while (index != maxIndex) {//转一圈
            value = arr[index];
            while (!stack.isEmpty() && stack.peek().value < value) {
                int times = stack.pop().times;
//                res += getInternalSum(times) + times;
//                res += stack.isEmpty() ? 0 : times;
                res += getInternalSum(times) + 2 * times;
            }
            if (!stack.isEmpty() && stack.peek().value == value) {
                stack.peek().times++;//相等的话累加
            } else {
                stack.push(new Pair(value));
            }
            index = nextIndex(size, index);
        }
        //跑完一圈后，结算栈里面剩下的
        while (!stack.isEmpty()) {
            int times = stack.pop().times;
            //不管什么，肯定会内部产生山峰对
            res += getInternalSum(times);
            if (!stack.isEmpty()) {//没到最后一个
                res += times;
                if (stack.size() > 1) {//3个及以上的情况
                    res += times;
                } else {//第2个的情况，要结合最后一个数来判断
                    res += stack.peek().times > 1 ? times : 0;
                }
            }
        }
        return res;
    }

    //简单Ck(下标)2(上标)
    private static long getInternalSum(int n) {
        return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
    }

    private static int nextIndex(int size, int i) {
        return i < (size - 1) ? (i + 1) : 0;
    }
}











