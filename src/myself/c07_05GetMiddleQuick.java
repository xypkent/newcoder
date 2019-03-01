package myself;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class c07_05GetMiddleQuick {

    public static class GetMiddlQucik {
        public static PriorityQueue<Integer> MaxHeap;
        public static PriorityQueue<Integer> MinHeap;

        public GetMiddlQucik() {
            MaxHeap = new PriorityQueue<>(new MaxCompare());
            MinHeap = new PriorityQueue<>(new MinCompare());
        }

        public void setNum(int num) {
            if (MaxHeap.isEmpty()) {
                MaxHeap.add(num);
            } else if (num <= MaxHeap.peek()) {
                MaxHeap.add(num);
            } else {
                MinHeap.add(num);
            }
            //时刻检查堆的数量情况
            if (MaxHeap.size() == MinHeap.size() + 2) {
                MinHeap.add(MaxHeap.poll());
            }
            if (MaxHeap.size() + 2 == MinHeap.size()) {
                MaxHeap.add(MinHeap.poll());
            }
        }

        public int GetMiddle() {
            int mins = MinHeap.size();
            int maxs = MaxHeap.size();
            if ((mins + maxs) % 2 == 0) {
                return (MaxHeap.peek() + MinHeap.peek()) / 2;
            }
            return mins > maxs?MinHeap.peek():MaxHeap.peek();

        }


    }

    public static class MinCompare implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MaxCompare implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    // for test
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean err = false;
        int testTimes = 200000;
        for (int i = 0; i != testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = getRandomArray(len, maxValue);
            GetMiddlQucik medianHold = new GetMiddlQucik();
            for (int j = 0; j != arr.length; j++) {
                medianHold.setNum(arr[j]);
            }
            if (medianHold.GetMiddle() != getMedianOfArray(arr)) {
                err = true;
                printArray(arr);
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }


}















