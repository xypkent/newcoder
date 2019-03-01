package myself;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class c03_QueueCoverStack {

	//两个栈模拟队列
	public static class TwoStackQueue {

		public Stack<Integer> push;
		public Stack<Integer> pop;

		public TwoStackQueue() {
			push = new Stack<Integer>();
			pop = new Stack<Integer>();
		}

		public void insert(int num){
			push.push(num);
		}

		public int poll(){
			if(!pop.isEmpty())
				return pop.pop();

			//为空就先检查一下push栈
			if(push.isEmpty())
				throw new RuntimeException("没有数据！");

			//倒数据操作
			while(!push.isEmpty()){
				pop.push(push.pop());
			}
			return pop.pop();
		}

	}

	//两个队列模拟栈
	public static class TwoQueueStack {

		public Queue<Integer> queue;
		public Queue<Integer> helpqueue;

		public TwoQueueStack() {
			queue = new LinkedList<Integer>();
			helpqueue = new LinkedList<Integer>();
		}

		public void push(int num) {
			queue.add(num);
		}

		public int pop() {
			// 只留一个
			int size = queue.size();
			for (int i = 0; i < size - 1; i++) {
				helpqueue.add(queue.poll());
			}
			int num = queue.poll();
			// 切换引用
			copy();
			return num;

		}

		public int peek() {
			int size = queue.size();
			for (int i = 0; i < size - 1; i++) {
				helpqueue.add(queue.poll());
			}
			int num = queue.peek();
			helpqueue.add(queue.poll());
			// 切换引用
			copy();
			return num;

		}

		public void copy() {
			Object temp = queue;
			queue = helpqueue;
			helpqueue = (Queue<Integer>) temp;
		}
	}

	public static void main(String[] args) {
//		TwoQueueStack queueStack = new TwoQueueStack();
//		queueStack.push(1);
//		queueStack.push(2);
//		queueStack.push(3);
//		queueStack.push(4);
//		queueStack.push(5);
//
//		System.out.println(queueStack.peek());
//		System.out.println(queueStack.pop());
//		System.out.println(queueStack.pop());
//		System.out.println(queueStack.pop());
//		System.out.println(queueStack.pop());
//		System.out.println(queueStack.pop());

		TwoStackQueue queue = new TwoStackQueue();

		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);

		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());

		queue.insert(1);
		queue.insert(2);
		queue.insert(3);

		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());


	}

}
