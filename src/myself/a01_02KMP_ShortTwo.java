package myself;

public class a01_02KMP_ShortTwo {

    public static String getShorestTwo(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        if (chars.length == 1)
            return str + str;
        if (chars.length == 2)
            return chars[0] == chars[1] ? (str + str.charAt(0)) : str + str;
        int lastNext = getLastNextArray(chars);
        return str + str.substring(lastNext);
    }


    public static int getLastNextArray(char[] str) {

        int[] nextArray = new int[str.length + 1];

        nextArray[0] = -1;
        nextArray[1] = 0;
        int cur = 2;
        int jump = 0;
        while (cur < nextArray.length) {
            if (str[cur - 1] == nextArray[jump]) {
                nextArray[cur++] = ++jump;
            } else if (jump > 0) {
                jump = nextArray[jump];
            } else {
                nextArray[cur++] = 0;
            }
        }
        return nextArray[cur - 1];

    }

}
