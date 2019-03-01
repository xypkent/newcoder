package class_05;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code_04_UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> sizeMap;

		//创建的时候就要一次性导入所有的节点
		public UnionFindSet(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			makeSets(nodes);
		}

		private void makeSets(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);//一开始自己是自己的父亲
				sizeMap.put(node, 1);//大小为1
			}
		}


		private Node findHead(Node node) {

			//非递归版本
			Stack<Node> Nodes = new Stack<>();
			Node cur = node;
			Node parent = fatherMap.get(cur);

			while(cur != parent){
				Nodes.push(cur);
				cur = parent;
				parent = fatherMap.get(cur);
			}
			while(!Nodes.isEmpty()){
				fatherMap.put(Nodes.pop(),parent);
			}
			return parent;

			//递归版本
			/*
			//获得节点的父节点
			Node father = fatherMap.get(node);
			if (father != node) {//这样找是因为头节点是自己指向自己的
				//一路向上找父节点
				father = findHead(father);
			}
			fatherMap.put(node, father);//路径压缩
			return father;*/
		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize= sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				if (aSetSize <= bSetSize) {//a小于b
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {//a大于b
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
