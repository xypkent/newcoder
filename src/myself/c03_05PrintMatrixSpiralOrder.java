package myself;

public class c03_05PrintMatrixSpiralOrder {

    public static void spiralPrint(int[][] matrix) {
        //左上角a点
        int ax = 0, ay = 0;
        //右下角b点
        int bx = matrix.length - 1;
        int by = matrix[0].length - 1;
        //如果两个点没有相遇，就继续打印
        while (ax <= bx && ay <= by) {
            printEdge(matrix, ax++, ay++, bx--, by--);
        }
    }

    public static void printEdge(int[][] m, int ax, int ay, int bx, int by) {
        if (ax == bx) {
            for (int i = ay; i <= by; i++) {
                System.out.printf(m[ax][i] + " ");
            }
        } else if (ay == by) {
            for (int i = ax; i <= bx; i++) {
                System.out.printf(m[i][ay] + " ");
            }
        } else {
            for (int i = ax; i < by; i++) {
                System.out.printf(m[ax][i] + " ");
            }
            for (int i = ax; i < bx; i++) {
                System.out.printf(m[i][by] + " ");
            }
            for (int i = by; i > ay; i--) {
                System.out.printf(m[bx][i] + " ");
            }
            for (int i = bx; i > ax; i--) {
                System.out.printf(m[i][ay] + " ");
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 ,4},
                { 5, 6, 7 ,8},
                { 9, 10, 11 ,12}};
//        int[][] matrix = {
//                { 1, 2, 3 },
//                { 4, 5, 6 },
//                { 7, 8, 9 },
//                { 10, 11, 12 } };
//        int[][] matrix = {
//                { 1, 2, 3, 4 },
//                { 5, 6, 7, 8 },
//                { 9, 10, 11, 12 },
//                { 13, 14, 15, 16 } };
        spiralPrint(matrix);

    }


}
