package basic_class_02;

public class Code_04_Manacher {

    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        //回文半径数组
        int[] pArr = new int[charArr.length];
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            //i'的回文和i~R的距离，谁更近就是i的瓶颈
            //2 * C - i --> i'的位置
            //pArr[2 * C - i]  i'的回文半径
            //R - i --> i到R的距离
            //R > i i在R的边界里面
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            //全部情况都往外扩，虽然情况2、3扩充一次后会直接失败，但统一简化了代码
            //检查是否越界
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            //如果扩充区域超过了R，做相应的更新
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            //记录全局最大值
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }

}
