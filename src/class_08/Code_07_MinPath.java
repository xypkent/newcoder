package class_08;

public class Code_07_MinPath {

    public static int minPath1(int[][] matrix) {
        return process1(matrix, matrix.length - 1, matrix[0].length - 1);
    }

    //从{i,j}出发，到达最右下角位置，最小路径和是多少？
    public static int process1(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == 0 && j == 0) {
            return res;
        }
        if (i == 0 && j != 0) {
            return res + process1(matrix, i, j - 1);
        }
        if (i != 0 && j == 0) {
            return res + process1(matrix, i - 1, j);
        }
        return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
    }

    //动态规划
    public static int minPath2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        //第一列赋值
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        //第一行赋值
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        //最优赋值
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    //课堂上的代码
    public static int walk(int[][] matrix, int i, int j) {
        int x = matrix.length - 1;
        int y = matrix[0].length - 1;
        if (i == x && j == y) {
            return matrix[i][j];
        }
        if (i == x)//如果i到达行底部，只能向右走。
            return matrix[i][j] + walk(matrix, i, j + 1);

        if (j == y)//如果j到达列边界，只能向下走。
            return matrix[i][j] + walk(matrix, i + 1, j);
        //其他情况，需要对向下和向右进行对比，选出最优解
        int right = walk(matrix, i, j + 1);
        int down = walk(matrix, i + 1, j);
        return matrix[i][j] + Math.min(right, down);

    }


    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }
}
