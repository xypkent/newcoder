package myself;

public class a07_02CoinsWay {

    public static int coins1(int[] nums, int aim){
        if (nums == null || nums.length < 0) {
            return 0;
        }
        return process(nums,0,aim);
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

}
