package myself;

public class a01_05Mannacher_ShortestEnd {

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

    public static String getShorestEnd(String str) {
        if (str == null || str.length() == 0) {
            return "";
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
            if (R == chars.length) {//获得第一个达到终点的回文
                break;
            }
        }
        //获得左边界。
        int L = chars.length - (2 * radius[C]);
        for (int i = L; i > 0; i--) {
            str += chars[i--];
        }
        return str;
    }

    public static void main(String[] args) {
        String str2 = "abcd123321";
        System.out.println(getShorestEnd(str2));
    }


}
