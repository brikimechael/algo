package algo.graph.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left;


    Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class MinHeapMaxHeap {
    public static void displayTree(Node root) {
        displayTree(root, "");
    }

    private static void displayTree(Node node, String prefix) {
        if (node != null) {
            displayTree(node.right, prefix + "        ");
            System.out.println(prefix + " /-- " + node.value + " --\\");
            displayTree(node.left, prefix + "        ");
        }
    }

    private static void printIndent(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("  "); // Two spaces for each level of indentation
        }
    }
    //complete binary tree


    // add node
    void addNode(Node newRoot, Node node) {
        while (node != null) {
            Node tmp = node.left;

            node = node.left;
            node.left = tmp.right;

        }
    }
    // delete node with left value shift
    //

    void deleteNode( Node node) {
        Node prevPointer=null;
       while(node!=null) {
           if (node.left != null) {
               node.value = node.left.value;
           }
           else{
               prevPointer.left=null;
               break;
           }
           prevPointer=node;
           node=node.left;
       }
    }



    boolean check(int nodeValue, Node left, Node right) {
        return nodeValue > (left != null ? left.value : Integer.MIN_VALUE) && nodeValue > (right != null ? right.value : Integer.MIN_VALUE);
    }


    // put it as new right
    // put it as new left
    // put it in place of node

    void insert(Node parent,int nodeValue, Node node,int dir) {
        if(node!=null){
            if(node.value>nodeValue &&parent!=null&& parent.value< nodeValue){
                if(node.left==null){
                    node.left = new Node(nodeValue,null,null);
                }
                else if(node.right ==null){
                    node.right = new Node(nodeValue,null,null);
                }
                else {
                    if(dir==-1){
                        parent.left = new Node(nodeValue,node,null);
                    }
                    else {
                        parent.right = new Node(nodeValue,node,null);
                    }
                }

                return;
            }
            insert(node,nodeValue,node.left,-1);
            insert(node,nodeValue,node.right,1);
        }
    }


    void insert1(Node node,int value,Node parent) {
        if(node!=null){

            //node inseted between
            if(node.value>value) {
                Node tmp = new Node(node.value,node.left,null);
                node.value = value;
                node.left = tmp;
            }

            //node inserted as leaf





            insert1(node.left,value,node);
            insert1(node.right,value,node);

        }
    }



    void display(Node node) {
        if (node != null) {
            System.out.println(node.value);
            display(node.left);
            display(node.right);
        }
    }


    public static void main(String[] args) {
        MinHeapMaxHeap minHeapMaxHeap = new MinHeapMaxHeap();
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, null, null);
        Node node5 = new Node(5, node7, null);
        Node node4 = new Node(4, null, null);
        Node node3 = new Node(3, node5, node6);
        Node node1 = new Node(1, node3, node4);



        minHeapMaxHeap.insert(null,2,node1,0);
        //minHeapMaxHeap.deleteNode(node3);
        //minHeapMaxHeap.display(node1);
        MinHeapMaxHeap.displayTree(node1);
    }


}
