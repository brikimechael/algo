package algo.collection;

public class Stack<T extends Comparable<T>> {


    // implement pop, push , peek

    Node<T> currentNode;

    int size =0;


     public T pop() throws Exception {

        if(currentNode!=null){
            Node<T> tmp = currentNode;
            currentNode=currentNode.next;
            size--;
            return tmp.element;
        }
        throw new Exception("Stack is empty");
     }

     public void push(T element){
        Node<T> newNode = new Node<>(element);
        newNode.next=currentNode;
        size++;
        currentNode=newNode;
     }

     public T peek() throws Exception {
         if(currentNode!=null){
             return currentNode.element;
         }
         throw new Exception("Stack is empty");
     }

     public int size(){
         return this.size;
     }

     boolean isEmpty(){
         return size ==0;
     }





    public static void main(String[] args) throws Exception {


        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        System.out.println(stack.pop());
        System.out.println(stack.peek());


    }
}
