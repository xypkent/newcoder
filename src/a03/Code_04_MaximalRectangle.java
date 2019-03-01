package a03;

import java.util.Stack;

public class Code_04_MaximalRectangle {


    //height数组表示在以当前行作为底的情况下，每个位置往上的连续的 1 的数量
    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        //辅助数组
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    //找到柱子左边刚比它小的柱子位置，以及右边刚比它大的柱子位置，用栈计算最快
    //最基本的方法，如果一个数组表示直方图的话，在其中找到最大正方形
    //例如：[4,3,2,5,6]代表一个直方图
    private static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        //遍历数组中的每一个数
        for (int i = 0; i < height.length; i++) {
            //不断循环，直到当前位置的值小于栈顶元素
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();//值
                int k = stack.isEmpty() ? -1 : stack.peek();//左边界
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(curArea, maxArea);
            }
            stack.push(i);
        }

        // 针对的是从栈底到栈顶一直递增的情况
        //结算栈中剩下的东西
        while (!stack.isEmpty()) {
            int j = stack.pop();//值
            int k = stack.isEmpty() ? -1 : stack.peek();//左边界
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] num = new int[][]{
                {0,1,0,0,0,0},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1}
        };
        System.out.println(maxRecSize(num));
    }

}
