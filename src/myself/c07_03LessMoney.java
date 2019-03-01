package myself;

import java.util.Comparator;
import java.util.PriorityQueue;

public class c07_03LessMoney {

    public static int lessMoney(int[] length) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int i = 0; i != length.length; i++) {
            priorityQueue.add(length[i]);
        }
        int money = 0;
        int cur = 0;
        while (priorityQueue.size() > 1) {
            cur = priorityQueue.poll() + priorityQueue.poll();
            money += cur;
            priorityQueue.add(cur);
        }
        return money;
    }

    public static class MinComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return a - b;
        }
    }

    public static class MaxComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return -(a - b);
        }
    }

    public static void main(String[] args) {
        // solution
        int[] arr = {6, 7, 8, 9};
        System.out.println(lessMoney(arr));

        int[] arrForHeap = {3, 5, 2, 7, 0, 1, 6, 4};

        // min heap
        PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ1.add(arrForHeap[i]);
        }
        while (!minQ1.isEmpty()) {
            System.out.print(minQ1.poll() + " ");
        }
        System.out.println();

        // min heap use Comparator
        PriorityQueue<Integer> minQ2 = new PriorityQueue<>(new MinComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ2.add(arrForHeap[i]);
        }
        while (!minQ2.isEmpty()) {
            System.out.print(minQ2.poll() + " ");
        }
        System.out.println();

        // max heap use Comparator
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(new MaxComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            maxQ.add(arrForHeap[i]);
        }
        while (!maxQ.isEmpty()) {
            System.out.print(maxQ.poll() + " ");
        }
    }


}



















