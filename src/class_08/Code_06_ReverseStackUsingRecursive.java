package class_08;

import java.util.Stack;

public class Code_06_ReverseStackUsingRecursive {

	/**
	 * 以1，2，3为例，从栈顶到栈底依次为3，2，1
	 */
	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);//得到栈底元素
		reverse(stack);//递归，所以i依次为1，2，3
		stack.push(i);//回溯，依次压入3，2，1
	}

	//得到栈底元素并它移除，并且其它元素压回栈
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);//回溯，将其它元素重新压回栈
			return last;//返回栈底元素
		}
	}

	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		reverse(test);
		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}

	}

}
