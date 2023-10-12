package algo.linkedList;

import java.util.*;

public class Test {

    class Node {
        public int data;
        public Node next;
    }


    void removeDuplicates(Node head) {
        Node tmp = head;
        Set<Integer> items = new HashSet<>();
        Node prev = null;
        while (tmp != null) {
            if (items.contains(tmp.data)) {
                prev.next = tmp.next;
            } else {
                prev = tmp;
            }
            items.add(tmp.data);
            tmp = tmp.next;
        }

    }


    Node dummyNodeList() {
        Node head = new Node();
        Node tmp = head;
        for (int i = 0; i < 5; i++) {
            tmp.data = i;
            tmp.next = new Node();
            tmp = tmp.next;
        }
        for (int i = 0; i < 6; i++) {
            tmp.data = i + 1;
            tmp.next = new Node();
            tmp = tmp.next;

        }
        tmp.data = 5;
        tmp.next = null;
        return head;
    }

    public static void main(String[] args) {

        Test test = new Test();
        Node head = test.dummyNodeList();
        test.removeDuplicates(head);

    }
}
