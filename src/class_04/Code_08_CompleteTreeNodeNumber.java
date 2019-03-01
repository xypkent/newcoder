package class_04;

public class Code_08_CompleteTreeNodeNumber {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}
	//当前节点、节点在第几层、整棵树的树高
	public static int bs(Node node, int level, int h) {
		if (level == h) {//如果level来到最后一层，就是叶子节点
			return 1;
		}
		if (mostLeftLevel(node.right, level + 1) == h) {
			return (1 << (h - level)) + bs(node.right, level + 1, h);
		} else {
			return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
		}
	}

	public static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}

}
