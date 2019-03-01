package myself;

public class c03_06RotateMatrix {

    public static void rotate(int[][] matrix) {
        //确定左上角和右下角的点，方便划分任务
        int ax = 0, ay = 0;
        int bx = matrix.length - 1;
        int by = matrix[0].length - 1;

        while (ax < bx) {
            rotateEdge(matrix, ax++, ay++, bx--, by--);
        }
    }

    public static void rotateEdge(int[][] m, int ax, int ay, int bx, int by) {
        //首先计算要交换的次数
        int count = by - ay;
        int tmp = 0;
        for (int i = 0; i != count; i++) {
            tmp = m[ax ][ay+ i];
            m[ax][ay + i] = m[bx - i][ay];
            m[bx - i][ay] = m[bx][by - i];
            m[bx ][by- i] = m[ax + i][by];
            m[ax + i][by] = tmp;
        }

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }


}
