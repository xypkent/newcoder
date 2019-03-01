package basic_class_02;

public class Code_01_KMP {

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		//匹配下标
		int i1 = 0;
		int i2 = 0;
		int[] next = getNextArray(ms);
		while (i1 < ss.length && i2 < ms.length) {
			if (ss[i1] == ms[i2]) {
				i1++;
				i2++;
			} else if (next[i2] == -1) {//-1标志数组第一个字符
				i1++;//开头都配不上，就++
			} else {
				i2 = next[i2];//根据next的指引，往前跳，继续比对
			}
		}
		return i2 == ms.length ? i1 - i2 : -1;
	}

	public static int[] getNextArray(char[] str2) {
		if (str2.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[str2.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;//跳到的位置
		while (pos < next.length) {
			if (str2[pos - 1] == str2[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));

	}

}
