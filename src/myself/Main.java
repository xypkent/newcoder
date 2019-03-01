package myself;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int ans = 0, x;
            int N, A, B, C;
            for (int i = 0; i < n; i++) {
                N = sc.nextInt();
                A = sc.nextInt();
                B = sc.nextInt();
                C = sc.nextInt();

                N = N - B / 3 - C / 2;
                B %= 3;
                C %= 2;

                if (N <= 0) System.out.println("Yes");
                else if ((A + B * 2 + 3 * C < 6 * N) || ((A + B * 2 + 3 * C >= 6 * N) && (A == 0)))
                    System.out.println("No");
                else System.out.println("Yes");
            }

        }


    }

}
