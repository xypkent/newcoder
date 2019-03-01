package myself;

import java.util.Stack;

public class c08_03ReverseStack {

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getLastAndRemove(stack);
        reverse(stack);
        stack.push(i);
    }

    private static int getLastAndRemove(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()){
            return result;//如果是空就返回最后一个元素
        }else{
            int last = getLastAndRemove(stack);
            stack.push(result);//除了最后一个外，其他都重新安排进栈
            return last;//最后返回最后一个元素
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        reverse(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}















