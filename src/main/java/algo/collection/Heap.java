package algo.collection;

public class Heap {



    static class Node {
        Node left,right;
        int value;
        Node(int value){
            this.value = value;
        }
    }

    static Node heapify(int[]arr) throws Exception {
        int i=1;

        Node root = new Node(arr[i-1]);
        Node tmp = root;
        Queue<Node> q = new Queue<>();
        q.add(tmp);
        while(!q.isEmpty()){
            tmp=q.pop();
            i= tmp.value;
            if(2*i-1<arr.length) {
                tmp.left = new Node(arr[2 * i-1]);
                q.add(tmp.left);

            }
            else
                break;
            if(2*i<arr.length) {
                tmp.right = new Node(arr[2*i]);
                q.add(tmp.right);
            }
            else
                break;
        }
return root;
    }


    static void bfsTraversal(Node node) throws Exception {
        Node root = node;

        Queue<Node> q = new Queue<>();
        q.add(root);

        while (!q.isEmpty()){
            Node tmp = q.pop();
            System.out.println(tmp.value);
            if(tmp.left!=null)
            q.add(tmp.left);
            if(tmp.right!=null)
            q.add(tmp.right);
        }
    }
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3,4,5,6};
        /*
                    1
                   / \
                  2    3
                 /\   /\
                4  5 6
         */

        Node root = heapify(arr);
        bfsTraversal(root);


        // in k level ==> 2k,2k+1


    }
}
