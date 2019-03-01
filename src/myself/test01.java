package myself;

import java.util.Scanner;

public class test01 {


    static int count = 0;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {

            int n = in.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (f(i, j, arr)) {
                        count++;
                    }
                }
            }

            System.out.println(count);
            count = 0;

        }


    }

    private static boolean f(int i, int j, int arr[]) {
        // TODO Auto-generated method stub
        if (Math.abs(i - j) == 1 || Math.abs(i - j) == arr.length - 1) {

            return true;
        }
        boolean a = true, b = true;
        for (int k = i + 1; k < j; k++) {                //从左往右扫面，看两者之间有没有比他们高的
            if ((arr[k] > arr[i] || arr[k] > arr[j])) {
                a = false;
                break;
            }
        }

        for (int step = 1; step < arr.length - (j - i); step++) {        //从右往做扫面，看两者之间有没有比他们高的
            if ((arr[(step + j) % arr.length] > arr[i] || arr[(step + j) % arr.length] > arr[j])) {
                b = false;
                break;
            }
        }

        return a || b;
    }


}
