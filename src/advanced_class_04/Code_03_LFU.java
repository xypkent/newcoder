package advanced_class_04;

import java.util.HashMap;

public class Code_03_LFU {
	//小链表的节点
	public static class Node {
		public Integer key;
		public Integer value;
		public Integer times;
		public Node up;
		public Node down;

		public Node(int key, int value, int times) {
			this.key = key;
			this.value = value;
			this.times = times;
		}
	}

	public static class LFUCache {

		//把次数相同的节点连在一起的链表
		public static class NodeList {
			//本链的头尾
			public Node head;
			public Node tail;
			//前一个和后一个
			public NodeList last;
			public NodeList next;

			public NodeList(Node node) {
				head = node;
				tail = node;
			}

			public void addNodeFromHead(Node newHead) {
				newHead.down = head;
				head.up = newHead;
				head = newHead;
			}

			public boolean isEmpty() {
				return head == null;
			}

			//其中的任何节点都可能删，因为次数增加也要调整节点位置
			//把节点从本环境中分离
			public void deleteNode(Node node) {
				if (head == tail) {
					head = null;
					tail = null;
				} else {
					if (node == head) {//头
						head = node.down;
						head.up = null;
					} else if (node == tail) {//尾
						tail = node.up;
						tail.down = null;
					} else {//其中
						node.up.down = node.down;
						node.down.up = node.up;
					}
				}
				node.up = null;
				node.down = null;
			}
		}

		private int capacity;//容量
		private int size;//当前大小
		//通过key找Node
		private HashMap<Integer, Node> records;
		//找到Node的当前所在链表
		private HashMap<Node, NodeList> heads;
		private NodeList headList;

		public LFUCache(int capacity) {
			this.capacity = capacity;
			this.size = 0;
			this.records = new HashMap<>();
			this.heads = new HashMap<>();
			headList = null;
		}

		public void set(int key, int value) {
			if (records.containsKey(key)) {//存在
				Node node = records.get(key);
				node.value = value;
				node.times++;
				NodeList curNodeList = heads.get(node);
				move(node, curNodeList);//帮node找新家
			} else {
				if (size == capacity) {//腾出空间
					Node node = headList.tail;
					headList.deleteNode(node);
					modifyHeadList(headList);//检查是否要调整(有可能删光了)
					records.remove(node.key);
					heads.remove(node);
					size--;
				}
				Node node = new Node(key, value, 1);
				if (headList == null) {//第一次加
					headList = new NodeList(node);
				} else {
					//检查是否存在专属的次数链表
					if (headList.head.times.equals(node.times)) {
						headList.addNodeFromHead(node);
					} else {//没有就建
						NodeList newList = new NodeList(node);
						newList.next = headList;
						headList.last = newList;
						headList = newList;
					}
				}
				//记录信息
				records.put(key, node);
				heads.put(node, headList);
				size++;
			}
		}

		private void move(Node node, NodeList oldNodeList) {
			oldNodeList.deleteNode(node);//先从老家搬出
			//搬出后老家有可能因为无住户而被拆除，所以前指向要判断下
			NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last
					: oldNodeList;
			NodeList nextList = oldNodeList.next;
			if (nextList == null) {//新家不存在，建一个
				NodeList newList = new NodeList(node);
				if (preList != null) {//老家还在
					preList.next = newList;
				}
				newList.last = preList;
				//应对1---3的情况，删了1，后面没2，自然新建的2会变为新头
				//   ^a---^b
				if (headList == null) {
					headList = newList;
				}
				heads.put(node, newList);//加入记录
			} else {
				//新家合适，是老家+1的配套
				if (nextList.head.times.equals(node.times)) {
					nextList.addNodeFromHead(node);
					heads.put(node, nextList);
				} else {//新家不合适，建一个
					NodeList newList = new NodeList(node);
					if (preList != null) {//保证前一个节点不为空，不然下面代码报错
						preList.next = newList;
					}
					newList.last = preList;
					newList.next = nextList;
					nextList.last = newList;
					if (headList == nextList) {//判断头链表是否有变化
						headList = newList;
					}
					heads.put(node, newList);//加入记录
				}
			}
		}

		// return whether delete this head
		private boolean modifyHeadList(NodeList nodeList) {
			if (nodeList.isEmpty()) {//如果房子没有住户，要进行拆除
				if (headList == nodeList) {//如果是头节点
					headList = nodeList.next;
					if (headList != null) {//尾部的情况
						headList.last = null;
					}
				} else {//普通节点
					nodeList.last.next = nodeList.next;
					if (nodeList.next != null) {//尾部的话就是null的
						nodeList.next.last = nodeList.last;
					}
				}
				return true;
			}
			return false;
		}

		public int get(int key) {
			if (!records.containsKey(key)) {
				return -1;
			}
			Node node = records.get(key);
			node.times++;
			NodeList curNodeList = heads.get(node);
			move(node, curNodeList);//帮Node找新家
			return node.value;
		}

	}
}