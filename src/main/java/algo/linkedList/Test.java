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


    // reverse linkedList
    // iterative
    Node reverseAndCloneV1(Node head) {
        Node clone = new Node();
        clone.data = head.data;
        clone.next = null;
        while (head.next != null) {
            //next node
            Node toClone = new Node();
            toClone.data = head.next.data;
            toClone.next = clone;

            //move pointers
            clone = toClone;
            head = head.next;
        }
        return clone;
    }

    void fastDisplay(Node head) {
        System.out.print(head.data + " ");
        while (head.next != null && head.next.next != null) {
            System.out.print(head.next.next.data + " ");
        }
    }


    void display() {
        int[] a = {1, 2, 3, 4, 5, 6};

        int i = 1;
        while (2 * i <= a.length) {
            System.out.println(a[i - 1] + " " + a[2 * i - 1]);
            i++;
        }
    }


    // 2 pointetrs with stack
    boolean isPalindromeV1(Node head) {
        Node slow = head;
        Node fast = head.next;

        Stack<Node> stack = new Stack<>();
        if (fast != null) {
            stack.push(slow);
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                stack.push(slow);
                fast = fast.next.next;
            }
            if (fast.next != null) {
                slow = slow.next.next;
            }
            while (slow != null) {
                if (stack.pop().data != slow.data) {
                    return false;
                }
                slow = slow.next;
            }
        }

        return true;
    }

    // use two pointers with hashmap
    boolean isPalindrome(Node head) {
        Node fast = head, slow = head;
        Map<Node, Node> prev = new HashMap<>();

        while (fast.next != null) {
            prev.put(fast.next, fast);
            fast = fast.next;
        }
        while (prev.get(fast) != null) {
            if (fast.data != slow.data) {
                return false;
            }
            prev.remove(slow);
            slow = slow.next;
            fast = prev.get(fast);
        }
        return true;
    }

    void displayList(Node head) {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }


    // basic solution
    Node intersectCheck(Node node1, Node node2) {
       int n1Length=0,n2Length=0;
       Node n1=node1,n2=node2;
       while(n1.next!=null){
           n1Length++;
           n1=n1.next;

       }
        while(n2.next!=null){
            n2Length++;
            n2=n2.next;
        }
        Node lastMatch =null;
        if(n1==n2) {
            Node n1Last=node1,n2Last=node2;
            int i = 0;
            if (n1Length > n2Length) {

                while (i < n1Length - n2Length) {
                    n1Last =n1Last.next;
                    i++;
                }

            }
            else {
                while (i < n2Length - n1Length) {
                    n2Last =n2Last.next;
                    i++;
                }
            }
            while(n1Last!=n2Last){
                n1Last=n1Last.next;
                n2Last=n2Last.next;
            }
            lastMatch=n1Last;
        }
        return lastMatch;
    }


    Node dummyNodeList() {
        Node head = new Node();
        Node tmp = head;
        for (int i = 0; i < 5; i++) {
            tmp.data = i;
            tmp.next = new Node();
            tmp = tmp.next;
        }
        for (int i = 4; i > 0; i--) {
            tmp.data = i;
            tmp.next = new Node();
            tmp = tmp.next;

        }
        tmp.data = 0;
        tmp.next = null;
        return head;
    }

    public static void main(String[] args) {

        Test test = new Test();
        Node head = test.dummyNodeList();
        // Node reversed = test.reverseAndCloneV1(head);
        test.displayList(head);
        //test.removeDuplicates(head);
        System.out.println(test.isPalindrome(head));

        // test.display();
    }
}
