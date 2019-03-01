package myself;

public class c03_08ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int ax = 0, ay = 0, bx = 0, by = 0;
        int endx = matrix.length - 1;
        int endy = matrix[0].length - 1;
        boolean upOrdown = false;
        while (ax != endx + 1) {
            printLevel(matrix, ax, ay, bx, by, upOrdown);
            ax = ay == endy ? ax + 1 : ax;
            ay = ay == endy ? ay : ay + 1;
            by = bx == endx ? by + 1 : by;
            bx = bx == endx ? bx : bx + 1;
            upOrdown = !upOrdown;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int ax, int ay, int bx, int by, boolean f) {

        if (f) {//向下打印
            while (ax != bx + 1) {
                System.out.print(m[ax++][ay--] + " ");
            }
        } else {//向上打印
            while (bx != ax - 1) {
                System.out.print(m[bx--][by++] + " ");
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);
    }


}
