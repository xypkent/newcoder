package a02;

import java.util.HashMap;
import java.util.LinkedList;
public class Code_01_SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr, int w) {
        if(arr == null || w < 1 || arr.length < w){
            return null;
        }
        
        LinkedList<Integer> qmax = new LinkedList<Integer>();//双向链表，双端队列
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            //当队列不是空且入队列的数大于原队列的最后一个数
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //每次加一个，缩一个的时候就看看头节点是否过期。
            ///当窗口向右移动，原来在窗口中的最左端数字失效了比如1234，w=3，移动到了4，3-3=0，所以下标为0的就失效，退出队列
            if(qmax.peekFirst() == i - w){
                qmax.pollFirst();
            }
            //当i大于等于窗口大小时才开始计算窗口里的最大值
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
        
    public static void main(String[] args) {
        int[] arr={2,3,4,2,6,2,5,1};
        int[] maxWindow = getMaxWindow(arr, 3);
        for (int i = 0; i < maxWindow.length; i++) {
            System.out.print(maxWindow[i]+"-");
        }
    }
}



