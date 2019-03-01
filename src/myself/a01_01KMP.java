package myself;

public class a01_01KMP {

    //查找str2是否在str1中
    public static int getIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null ||
                s2.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int[] next = getNextArray(cs2);
        int i1 = 0;
        int i2 = 0;
        while (i1 < cs1.length && i2 < cs2.length) {
            if (cs1[i1] == cs2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == cs2.length ? i1 - i2 : -1;
    }

    private static int[] getNextArray(char[] cs2) {
        if (cs2.length == 1) {
            return new int[]{-1};
        }
        int[] nextArray = new int[cs2.length];
        nextArray[0] = -1;
        nextArray[1] = 0;
        int cur = 2;//开始位置
        int jump = 0;//上一个最大前后缀的位置
        while (cur < nextArray.length) {
            if (cs2[cur -1] == cs2[jump]){
                nextArray[cur++] = ++jump;
            }else{
                if (jump > 0){
                    jump = nextArray[jump];
                }else {
                    nextArray[cur++] = 0;
                }
            }
        }
        return nextArray;
    }

}


















