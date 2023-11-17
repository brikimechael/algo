package algo.collection;

import java.util.concurrent.Callable;

public class StackMin <T extends Comparable<T>>{

    static class Node<T>{
        T element;
        public Node(T element){
            this.element = element;
        }
        Node<T> next;
        T min;
    }

Node<T> currentNode;


    public T min(){
        return currentNode.min;
    }

    public T pop() throws Exception {

        if(currentNode!=null){
            Node<T> tmp = currentNode;
            currentNode=currentNode.next;
            return tmp.element;
        }
        throw new Exception("Stack is empty");
    }

    public void push(T element){
       Node<T> newNode = new Node<>(element);
       if(currentNode==null){
           newNode.min=element;
       }
       else{
           newNode.min = element.compareTo(currentNode.min)<0 ? element: currentNode.min;
       }
        newNode.next=currentNode;
        currentNode=newNode;
    }

    public T peek() throws Exception {
        if(currentNode!=null){
            return currentNode.element;
        }
        throw new Exception("Stack is empty");
    }

}
