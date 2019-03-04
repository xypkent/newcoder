package advanced_class_04;

import java.util.HashMap;

public class Code_02_LRU {

	public static class Node<K,V> {
		public K key;
		public V value;
		public Node<K,V> last;
		public Node<K,V> next;

		public Node(K key,V value) {
			this.key = key;
			this.value = value;
		}
	}
	//定制的双向链表
	public static class NodeDoubleLinkedList<K,V> {
		private Node<K,V> head;
		private Node<K,V> tail;

		public NodeDoubleLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void addNode(Node<K,V> newNode) {
			if (newNode == null) {
				return;
			}
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
			} else {//最新的添加到尾部
				this.tail.next = newNode;
				newNode.last = this.tail;//新节点的前一个是之前的尾部
				this.tail = newNode;
			}
		}
		//操作节点后把结点调整在尾部
		public void moveNodeToTail(Node<K,V> node) {
			if (this.tail == node) {
				return;
			}
			//先把节点从环境分离
			if (this.head == node) {
				this.head = node.next;
				this.head.last = null;
			} else {//中间的普遍节点
				node.last.next = node.next;
				node.next.last = node.last;
			}
			node.last = this.tail;
			node.next = null;
			this.tail.next = node;
			this.tail = node;
		}
		//容量满了删除最不经常操作的数
		public Node<K,V> removeHead() {
			if (this.head == null) {
				return null;
			}
			Node<K,V> res = this.head;
			if (this.head == this.tail) {//只有一个节点
				this.head = null;
				this.tail = null;
			} else {
				this.head = res.next;
				res.next = null;
				this.head.last = null;
			}
			return res;
		}

	}

	public static class MyCache<K, V> {
		//通过key可以找到Node
		private HashMap<K, Node<K,V>> keyNodeMap;
		private NodeDoubleLinkedList<K,V> nodeList;
		private int capacity;

		public MyCache(int capacity) {
			if (capacity < 1) {
				throw new RuntimeException("should be more than 0.");
			}
			this.keyNodeMap = new HashMap<K, Node<K,V>>();
			this.nodeList = new NodeDoubleLinkedList<K,V>();
			this.capacity = capacity;
		}

		public V get(K key) {
			if (this.keyNodeMap.containsKey(key)) {
				Node<K,V> res = this.keyNodeMap.get(key);
				this.nodeList.moveNodeToTail(res);
				return res.value;
			}
			return null;
		}

		public void set(K key, V value) {
			if (this.keyNodeMap.containsKey(key)) {
				Node<K,V> node = this.keyNodeMap.get(key);
				node.value = value;
				this.nodeList.moveNodeToTail(node);
			} else {//没有就新增
				Node<K,V> newNode = new Node<K,V>(key,value);
				this.keyNodeMap.put(key, newNode);
				this.nodeList.addNode(newNode);
				if (this.keyNodeMap.size() == this.capacity + 1) {
					this.removeMostUnusedCache();
				}
			}
		}

		private void removeMostUnusedCache() {
			Node<K,V> removeNode = this.nodeList.removeHead();//取出优先级最低的
			K removeKey = removeNode.key;
			this.keyNodeMap.remove(removeKey);
		}

	}

	public static void main(String[] args) {
		MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
		testCache.set("A", 1);
		testCache.set("B", 2);
		testCache.set("C", 3);
		System.out.println(testCache.get("B"));
		System.out.println(testCache.get("A"));
		testCache.set("D", 4);
		System.out.println(testCache.get("D"));
		System.out.println(testCache.get("C"));

	}

}
