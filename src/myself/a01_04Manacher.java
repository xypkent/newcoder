package myself;

public class a01_04Manacher {

    private static char[] addPlaceHolder(String str) {
        char[] res = str.toCharArray();
        char[] chars = new char[str.length() * 2 + 1];
        int i = 0;
        int sIndex = 0;
        while (i < chars.length) {
            if (i % 2 == 0)
                chars[i] = '#';
            else
                chars[i] = res[sIndex++];
            i++;
        }
        return chars;
    }

    public static int getMaxLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] chars = addPlaceHolder(str);
        int[] radius = new int[chars.length];
        int max = Integer.MIN_VALUE;
        int R = -1;
        int C = -1;
        for (int i = 0; i != chars.length; i++) {
            radius[i] = R > i ? Math.max(radius[2 * C - i], R - i) : 1;
            while (i + radius[i] < chars.length && i - radius[i] > -1) {
                if (chars[i + radius[i]] == chars[i - radius[i]]) {
                    radius[i]++;
                } else {
                    break;
                }
            }
            if (i + radius[i] > R) {
                R = i + radius[i];
                C = i;
            }
            max = Math.max(max, radius[i]);
        }
        return max / 2;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(getMaxLength(str1));
    }

}
