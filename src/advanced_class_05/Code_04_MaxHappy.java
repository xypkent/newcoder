package advanced_class_05;

import java.util.ArrayList;

public class Code_04_MaxHappy {

	public static class Node{
		public int happy;
		public ArrayList<Node> nexts;

		public Node(int happy){
			this.happy  = happy;
			nexts = new ArrayList<Node>();
		}
	}

	public static class ReturnData{
		public int comeHappy;
		public int notComeHappy;

		public ReturnData(int c,int nc){
			comeHappy = c;
			notComeHappy = nc;
		}
	}

	public static ReturnData process(Node head){
		int comeHappy = head.happy;
		int notComeHappy = 0;

		for (int i = 0;i!=head.nexts.size();i++){
			ReturnData data = process(head.nexts.get(i));
			comeHappy += data.notComeHappy;
			notComeHappy += Math.max(data.notComeHappy,data.comeHappy);
		}
		return new ReturnData(comeHappy,notComeHappy);
	}

	public static int calcMaxHappy(Node head){
		ReturnData data = process(head);
		return Math.max(data.comeHappy, data.notComeHappy);
	}

	//下面是用数组结构去求
	public static int maxHappy(int[][] matrix) {
		int[][] dp = new int[matrix.length][2];
		boolean[] visited = new boolean[matrix.length];
		int root = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (i == matrix[i][0]) {
				root = i;
			}
		}
		process(matrix, dp, visited, root);
		return Math.max(dp[root][0], dp[root][1]);
	}

	public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
		visited[root] = true;
		dp[root][1] = matrix[root][1];
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == root && !visited[i]) {
				process(matrix, dp, visited, i);
				dp[root][1] += dp[i][0];
				dp[root][0] += Math.max(dp[i][1], dp[i][0]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
		System.out.println(maxHappy(matrix));
	}
}
