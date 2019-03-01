package myself;

public class c08_Print_Full_Permutation {

    public static void printAll(char[] chars, int i) {
        if (i == chars.length)
            System.out.println(String.valueOf(chars));
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            printAll(chars, i + 1);
        }
    }

    public static void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public static void main(String[] args) {
        String test = "abc";
        printAll(test.toCharArray(), 0);
    }

}
