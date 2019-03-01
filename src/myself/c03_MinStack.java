package myself;

import java.util.Stack;

public class c03_MinStack {

	public static class minStack {

		public static Stack<Integer> stack = new Stack<Integer>();
		public static Stack<Integer> minstack = new Stack<Integer>();

		public static void push(int num) {
			if(stack.isEmpty()){
				minstack.push(num);
			}else {
				minstack.push(num <= minstack.peek()? num:minstack.peek());
			}
			stack.push(num);
		}
	}

	public static void main(String[] args) {

	}

}
