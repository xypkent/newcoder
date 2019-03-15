package advanced_class_06;

public class Alibaba_Robot {


    public static int walk(int N, int curPosition, int remainSteps, int K) {
        if (N < 1 || curPosition < 1 || curPosition > N || remainSteps < 0 || K > N) {
            return 0;
        }

        if (remainSteps == 0) {
            return curPosition == K ? 1 : 0;
        }
        int count = 0;
        if (curPosition == 1) {
            count = walk(N, curPosition + 1, remainSteps - 1, K);
        } else if (curPosition == N) {
            count = walk(N, curPosition - 1, remainSteps - 1, K);
        } else {
            count = walk(N, curPosition + 1, remainSteps - 1, K) + walk(N, curPosition - 1, remainSteps - 1, K);
        }
        return count;
    }

    public static int dpWalk(int N, int curPosition, int remainSteps, int K) {
        int[][] dp = new int[remainSteps + 1][N + 1];
        dp[0][K] = 1;

        for (int i = 1; i <= remainSteps; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] += j - 1 < 1 ? 0 : dp[i - 1][j - 1];
                dp[i][j] += j + 1 > N ? 0 : dp[i - 1][j + 1];
            }
        }

        return dp[remainSteps][curPosition];
    }

    public static void main(String[] args) {
        System.out.println(walk(5, 3, 0, 3));
        System.out.println(walk(5, 3, 2, 3));
        System.out.println(dpWalk(5, 3, 0, 3));
        System.out.println(dpWalk(5, 3, 2, 3));
    }

}









