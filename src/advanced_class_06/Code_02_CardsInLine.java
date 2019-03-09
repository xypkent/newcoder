package advanced_class_06;

public class Code_02_CardsInLine {

	public static int win1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
	}

	public static int f(int[] arr, int i, int j) {//先拿的
		//如果i == j，即arr[i...j]上只有一张纸牌，当然会被先拿纸牌的人拿走，所以可以返回arr[i];
		if (i == j) {
			return arr[i];
		}
		//拿了其中一个之后，当前玩家成了后拿的那个人
		//因为当前的玩家会做出最好的选择，所以会拿走最好的
		return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
	}

	public static int s(int[] arr, int i, int j) {//后拿的
		//如果i == j，即arr[i...j]上只有一张纸牌，作为后拿的人必然什么也得不到，所以返回0；
		if (i == j) {
			return 0;
		}
		//因为对手会拿走最好的，所以当前玩家只能拿最差的
		return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
	}

	public static int win2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		for (int j = 0; j < arr.length; j++) {
			f[j][j] = arr[j];
			for (int i = j - 1; i >= 0; i--) {
				f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
				s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
			}
		}
		return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, 1 };
		System.out.println(win1(arr));
		System.out.println(win2(arr));

	}

}
