package algo;


import java.util.Stack;

public class Recursion {





    // 206. Reverse Linked List

     static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


      // reverse iteratively
    private static ListNode reverseListIterative(ListNode head) {
        ListNode p1 = null;
        ListNode p2 = head;
        while(p2!=null){
            ListNode tmp = p2;
            p2=p2.next;
            tmp.next=p1;
            p1=tmp;
        }
        return p1;
    }




    private static ListNode reverseList(ListNode p1,ListNode p2){

         if(p2!=null){
             ListNode tmp = p2;
             p2=p2.next;
             tmp.next=p1;
             return reverseList(tmp,p2);
         }
         return p1;

    }

    private static void display(ListNode head){
         ListNode tmp = head;
         while (tmp!=null){
             System.out.println(tmp.val);
             tmp=tmp.next;
         }
    }


    // 234. is Palindrome linkedList
    // todo recursive way

    private static boolean isPalindrome(ListNode head){
         ListNode p1=head,p2=head.next;

    Stack<ListNode> stack = new java.util.Stack<>();
    stack.push(p1);
    if(p2!=null) {
        while (p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            p1=p1.next;
            stack.push(p1);
        }
        //check if list is impair ==> skip middle
        p1=p1.next;
        if(p2.next!=null){
            p1=p1.next;
        }

        while(p1!=null&&!stack.isEmpty()&&stack.pop().val==p1.val){
            p1=p1.next;
        }
        return stack.isEmpty() && p1 == null;
    }
    return true;
    }

    // 2130. maximum-twin-sum-of-a-linked-list
    public int pairSum(ListNode head) {


        int max = 0;

        // not stable
        ListNode p1=head,p2=head;
        if(p2.next!=null){
            p2=p2.next;
        }

            while(p2.next!=null&&p2.next.next!=null)
            {
                p1=p1.next;
                p2=p2.next.next;

            }

            ListNode rev =null;
            p1=p1.next;

            //in place switch
            while(p1!=null){
                ListNode next = p1.next;
                p1.next=rev;
                rev=p1;
                p1=next;
            }

            while(rev!=null){
                max= Math.max(rev.val + head.val, max);
                rev=rev.next;
                head=head.next;
            }



        return max;
    }

    //203. remove-linked-list-elements
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = head;
        ListNode ref = head;
        ListNode prev = null;
        while(tmp!=null){
            if(tmp.val==val){
                if(prev!=null){

                    prev.next=tmp.next;


                }
                else
                    ref=ref.next;


            }else{
                prev=tmp;
            }

            tmp=tmp.next;


        }

        return ref;

    }

    public static ListNode removeElementsRecursively(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {

            return removeElementsRecursively(head.next, val);
        } else {
            head.next = removeElementsRecursively(head.next, val);
            return head;
        }


    }

    // sort edges priority queue
    // when edges count == n-1 stop
    // check if edge contains unvisited vertices



        public static void main(String[] args) {

        ListNode node1 = new ListNode(1);

        ListNode node2=  new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4=  new ListNode(4);
        ListNode node5=  new ListNode(4);
        ListNode node6 = new ListNode(3);
        ListNode node7=  new ListNode(2);
        ListNode node8 = new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;

        //display(reverseListIterative(node1));
        //display(reverseList(null,node1));
        //System.out.println(isPalindrome(node1));
            ListNode res = removeElementsRecursively(node1,1);
            display(res);

    }
}
