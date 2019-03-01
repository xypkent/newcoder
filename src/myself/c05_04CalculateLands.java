package myself;

public class c05_04CalculateLands {

    public static int calculateIsland(int[][] arr) {

        int isLand = 0;
        for (int i = 0; i != arr.length; i++) {
            for (int j = 0; j != arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    infect(arr, i, j);
                    isLand++;
                }
            }
        }
        return isLand;
    }

    private static void infect(int[][] arr, int i, int j) {
        int cur = arr[i][j];
        //如果越界或者不需要感染的位置就返回
        if ( cur != 1 || i < 0 || i > arr.length - 1 || j < 0 || j > arr[0].length - 1) {
            return;
        }
        arr[i][j] = 2;
        infect(arr, i - 1, j);//上
        infect(arr, i + 1, j);//下
        infect(arr, i, j - 1);//左
        infect(arr, i, j + 1);//右
    }

    public static void main(String[] args) {
        int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(calculateIsland(m1));

        int[][] m2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(calculateIsland(m2));
    }

}
