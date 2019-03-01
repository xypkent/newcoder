package myself;

import java.util.HashMap;
import java.util.HashSet;

public class c03_14FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getLoopNodeByHashMap(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        HashSet<Node> nodeset = new HashSet<>();
        while (head != null) {
            if (nodeset.contains(head)) {
                return head;
            }
            nodeset.add(head);
            head = head.next;
        }
        return null;
    }

    public static Node getLoopNodeByPointer(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        //快指针走到null直接返回无环
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static Node noLoopByHashSet(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        HashSet<Node> NodeSet = new HashSet<>();
        while (head1 != null) {
            NodeSet.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (NodeSet.contains(head2)) {
                return head2;
            }
            head2 = head2.next;
        }

        return null;
    }

    public static Node noLoopByPointer(Node head1, Node head2) {

        int n1 = 0;
        Node end1 = head1;
        while (end1.next != null) {
            ++n1;
            end1 = end1.next;
        }
        int n2 = 0;
        Node end2 = head2;
        while (end2.next != null) {
            ++n2;
            end2 = end2.next;
        }

        if (end1 != end2) return null;

        int gap = 0;
        boolean flag = true;//1t 2f
        if (n1 >= n2) {
            gap = n1 - n2;
        } else {
            gap = n2 - n1;
            flag = false;
        }

        //不为0，就证明长度有差
        while (gap != 0) {
            if (flag) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
            gap--;
        }
        //一起走，找到相交点为止
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = head1;
        Node cur2 = head2;
        if (loop1 == loop2) {
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head2 ? head1 : head2;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }

            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                cur1 = cur1.next;
                if (cur1 == loop2) {
                    return loop1;
                }
            }
            return null;
        }

    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNodeByPointer(head1);
        Node loop2 = getLoopNodeByPointer(head2);
        if (loop1 == null && loop2 == null) {//两个无环
            return noLoopByPointer(head1, head2);
        }
        if (loop1 != null && loop2 != null) {//两个有环
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;//一个有环一个无环，不可能相交


    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
//        System.out.println(getLoopNodeByHashMap(head1));
//        System.out.println(getLoopNodeByPointer(head1));

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
//        System.out.println(getLoopNodeByHashMap(head1).value);
//        System.out.println(getLoopNodeByPointer(head1).value);

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);
//        System.out.println(getLoopNodeByHashMap(head2).value);
//        System.out.println(getLoopNodeByPointer(head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
//        System.out.println(getLoopNodeByHashMap(head2).value);
//        System.out.println(getLoopNodeByPointer(head2).value);
    }

}






























