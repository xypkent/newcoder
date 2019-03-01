package class_03;

public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int ax = 0;
		int ay = 0;
		int bx = 0;
		int by = 0;
		int endX = matrix.length - 1;
		int endY = matrix[0].length - 1;
		boolean fromUp = false;
		while (ax != endX + 1) {
			printLevel(matrix, ax, ay, bx, by, fromUp);
			ax = ay == endY ? ax + 1 : ax;
			ay = ay == endY ? ay : ay + 1;
			by = bx == endX ? by + 1 : by;
			bx = bx == endX ? bx : bx + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int ax, int ay, int bx, int by,
			boolean f) {
		if (f) {
			while (ax != bx + 1) {
				System.out.print(m[ax++][ay--] + " ");
			}
		} else {
			while (bx != ax - 1) {
				System.out.print(m[bx--][by++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
