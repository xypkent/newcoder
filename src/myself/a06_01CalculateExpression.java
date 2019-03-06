package myself;

import java.util.LinkedList;

public class a06_01CalculateExpression {

    public static int getValue(String ss) {
        return process(ss.toCharArray(), 0)[0];
    }

    public static int[] process(char[] str, int i) {

        LinkedList<String> item = new LinkedList<>();
        int num = 0;
        int[] subProcess = null;//0累加值 1下一个开始位置
        while (i < str.length && str[i] != ')' ) {
            char cur = str[i];
            if (cur >= '0' && cur <= '9') {
                num = num * 10 + cur - '0';
                i++;
            } else if (cur != '(') {// + - * /
                addNum(item, num);
                item.addLast(String.valueOf(cur));
                i++;
                num = 0;
            } else {// ( 的情况
                subProcess = process(str, i + 1);
                num = subProcess[0];
                i = subProcess[1] + 1;
            }
        }
        addNum(item, num);
        int count = getNum(item);
        return new int[]{count, i};
    }

    //计算加减的结果
    private static int getNum(LinkedList<String> item) {
        boolean flag = true;//true + flase -
        int count = 0;
        while (!item.isEmpty()) {
            String s = item.pollFirst();
            if (s.equals("+")) {
                flag = true;
            } else if (s.equals("-")) {
                flag = false;
            } else {
                Integer num = Integer.valueOf(s);
                count += flag ? num : -num;
            }
        }
        return count;
    }

    private static void addNum(LinkedList<String> item, int num) {
        if (!item.isEmpty()) {
            String s = item.pollLast();
            if (s.equals("+") || s.equals("-")) {
                item.addLast(s);//放回去
            } else {//* /
                int preNum = Integer.valueOf(item.pollLast());
                num = s.equals("*") ? preNum * num : preNum / num;
            }
        }
        item.addLast(String.valueOf(num));
    }


    public static void main(String[] args) {
        String exp = "48*((70-65)-43)+8*1";
        System.out.println(getValue(exp));

        exp = "4*(6+78)+53-9/2+45*8";
        System.out.println(getValue(exp));

        exp = "10-5*3";
        System.out.println(getValue(exp));

        exp = "-3*4";
        System.out.println(getValue(exp));

        exp = "3+1*4";
        System.out.println(getValue(exp));
    }


}













