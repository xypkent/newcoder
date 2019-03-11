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

}
