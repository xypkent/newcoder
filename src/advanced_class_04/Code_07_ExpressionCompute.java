package advanced_class_04;

import java.util.LinkedList;

public class Code_07_ExpressionCompute {

	public static int getValue(String str) {
		return value(str.toCharArray(), 0)[0];
	}

	//返回数组[计算结果，计算到哪个位置]
	public static int[] value(char[] str, int i) {
		//双端队列
		LinkedList<String> que = new LinkedList<String>();
		int pre = 0;//收集数字
		int[] bra = null;
		while (i < str.length && str[i] != ')') {
			if (str[i] >= '0' && str[i] <= '9') {//把数字重组，注意有=
				pre = pre * 10 + str[i++] - '0';
			} else if (str[i] != '(') {// + - * /
				//收集数字和符号，数字+符号是一组
				addNum(que, pre);
				que.addLast(String.valueOf(str[i++]));
				pre = 0;//注意清0
			} else {// 当前i位置为(
				bra = value(str, i + 1);//不管，直接递归
				pre = bra[0];
				i = bra[1] + 1;
			}
		}
		addNum(que, pre);
		return new int[] { getNum(que), i };
	}

	public static void addNum(LinkedList<String> que, int num) {
		if (!que.isEmpty()) {
			int cur = 0;
			String top = que.pollLast();
			if (top.equals("+") || top.equals("-")) {
				que.addLast(top);//放回去
			} else {
				cur = Integer.valueOf(que.pollLast());
				num = top.equals("*") ? (cur * num) : (cur / num);
			}
		}
		que.addLast(String.valueOf(num));
	}

	//计算加减
	public static int getNum(LinkedList<String> que) {
		int res = 0;
		boolean add = true;
		String cur = null;
		int num = 0;
		while (!que.isEmpty()) {
			cur = que.pollFirst();
			if (cur.equals("+")) {
				add = true;
			} else if (cur.equals("-")) {
				add = false;
			} else {
				num = Integer.valueOf(cur);
				res += add ? num : (-num);
			}
		}
		return res;
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
