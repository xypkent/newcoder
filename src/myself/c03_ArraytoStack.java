package myself;

public class c03_ArraytoStack {

	public static class Queue {

		public static int[] Queue;
		public static int start = 0;
		public static int end = 0;
		public static int size = 0;

		public static void CreateQueue(int s) {

			if (s < 0)
				throw new IllegalArgumentException("大小输入违规");

			Queue = new int[s];

		}

		public static void insert(int num) {

			if (size == Queue.length - 1)
				throw new ArrayIndexOutOfBoundsException("array is full");

			Queue[start] = num;
			start = start == Queue.length - 1 ? 0 : start + 1;
			size++;
		}

		public static int out() {

			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("为空！");
			}
			size--;
			int theend = end;
			end = end == Queue.length - 1 ? 0 : end + 1;
			return theend;
		}

	}

	public static int[] Stack;
	public static int cur = -1;

	public static void CreateStack(int length) {
		Stack = new int[length];
	}

	private static void push(int num) {
		if (cur == Stack.length - 1) {
			throw new IllegalArgumentException("栈已经满了！");
		}
		Stack[++cur] = num;
	}

	private static int pop() {

		if (cur == -1) {
			throw new ArrayIndexOutOfBoundsException("没有数据！");
		}
		return Stack[cur--];
	}

	private static int peer() {
		if (cur == -1) {
			throw new ArrayIndexOutOfBoundsException("没有数据！");
		}
		return Stack[cur];

	}

	public static void main(String[] args) {

		CreateStack(3);
		push(1);
		push(2);
		push(3);

		System.out.println(peer());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());

	}

}
