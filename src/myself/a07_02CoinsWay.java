package myself;

public class a07_02CoinsWay {

    public static int coins1(int[] nums, int aim) {
        if (nums == null || nums.length < 0) {
            return 0;
        }
        return process(nums, 0, aim);
    }

    public static int process(int[] nums, int curIndex, int aim) {
        int res = 0;
        if (nums.length == curIndex) {
            return aim == 0 ? 1 : 0;
        }
        for (int i = 0; nums[curIndex] * i <= aim; i++) {
            res += process(nums, curIndex + 1, aim - nums[curIndex] * i);
        }
        return res;
    }

    public static int dpCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int i, j, k;
        int[][] dp = new int[arr.length][aim + 1];
        for (i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        int count = 0;
        for (i = 1; i < arr.length; i++) {
            for (j = 1; j <= aim; i++) {
                count = 0;
                for (k = 0; j - arr[i] * k >= 0; k++) {
                    count += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = count;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static int dpCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int i, j;
        int[][] dp = new int[arr.length][aim + 1];
        for (i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        for (i = 1; i < arr.length; i++) {
            for (j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j] ;

                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]]:0;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static void main(String[] args) {
        int[] coins = {10, 5, 1, 25};
        int aim = 2000;

        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
        System.out.println(coins1(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.println(dpCoins2(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        aim = 20000;

        start = System.currentTimeMillis();
        System.out.println(dpCoins2(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.println(dpCoins2(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.println(dpCoins2(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.println(dpCoins2(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");
    }

}




















