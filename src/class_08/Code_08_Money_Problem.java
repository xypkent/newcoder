package class_08;

public class Code_08_Money_Problem {

	public static boolean money1(int[] arr, int aim) {
		return process1(arr, 0, 0, aim);
	}

	public static boolean process1(int[] arr, int i, int sum, int aim) {
		if (sum == aim)
			return true;

		// sum != aim
		if (i == arr.length)
			return false;

		return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
	}

	public static boolean money2(int[] arr, int aim) {
		boolean[][] dp = new boolean[arr.length + 1][aim + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][aim] = true;//以目标金额为列的肯定为true
		}
		for (int i = arr.length - 1; i >= 0; i--) {//从最后一行开始
			for (int j = aim - 1; j >= 0; j--) {//aim往后的都超过，没必要看
				dp[i][j] = dp[i + 1][j];//通过直接的下方的判断。
				if (j + arr[i] <= aim) {//如果该数加上arr[i](当前可以累加的数)少于等于目标数。
					// 有可能可行，通过查看加上了arr[i](当前可以累加的数)的状态来判断
					dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
				}
			}
		}
		return dp[0][0];
	}

	public static boolean check(int[] arr,int i,int sum,int aim){
		if (i == arr.length){//判断是否走到最后一步
			return sum == aim;
		}
		return check(arr,i+1,sum,aim) || check(arr,i+1,sum+arr[i],aim);
	}



	public static void main(String[] args) {
		int[] arr = { 1, 4, 8 };
		int aim = 12;
//		System.out.println(money1(arr, aim));
//		System.out.println(money2(arr, aim));

		System.out.println(check(arr,0,0,aim));

	}

}



















