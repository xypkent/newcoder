package myself;

import java.util.Stack;

public class a03_02MaxRectangle {


    public static int getFinnallyMaxRectangle(int[][] rectangle) {
        if (rectangle == null || rectangle.length == 0 || rectangle[0].length == 0) {
            return 0;
        }
        int[] height = new int[rectangle[0].length];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i != rectangle.length; i++) {
            for (int j = 0; j != rectangle[0].length; j++) {
                height[j] = rectangle[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(getMaxRectangle(height), maxArea);
        }
        return maxArea;
    }

    public static int getMaxRectangle(int[] values) {
        if(values == null || values.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i != values.length; i++) {
            while (!stack.isEmpty() && values[i] <= values[stack.peek()]) {
                int value = values[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max((i - left - 1) * value, maxArea);
            }
            stack.push(i);
        }
        //栈里面剩下的
        while (!stack.isEmpty()) {
            int value = values[stack.pop()];
            int left = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max((values.length - left - 1) * value, maxArea);
        }
        return maxArea;

    }

    public static void main(String[] args) {
//        int[][] num = new int[][]{
//                {1, 0, 1, 1},
//                {1, 1, 1, 1},
//                {1, 1, 1, 0}};
        int[][] num = new int[][]{};
        System.out.println(getFinnallyMaxRectangle(num));
    }

}


















