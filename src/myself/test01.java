package myself;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test01 {

    public static void testPriorityQueue(){

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 3 5 5 6 7 8 9
        queue.add(3);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(5);

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int i = 0;
        while(i != k){
            System.out.print(queue.poll());
            i++;
        }


    }

    public static void main(String[] args){
//        testPriorityQueue();
        String helloWorld = "hello world";
        String hello = "hello";
        System.out.println(helloWorld == "hello" + " world");
        System.out.println(helloWorld == hello + " world");
        System.out.println(helloWorld.intern() ==
                (hello + " world").intern());
    }


}
