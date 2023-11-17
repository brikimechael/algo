package algo.collection;

public class Queue<T> {


// implement add,peek,remove


    Node<T> first;
    Node<T> last;

    void add(T element) {
        Node<T> newNode = new Node<>(element);
        if(last!=null) {
            last.next = newNode;
        }
        last = newNode;
        if (first == null) {
            first = last;
        }
    }
    boolean isEmpty(){
        return first==null;
    }

    T pop() throws Exception {
        if(isEmpty())
            throw new Exception("Queue is Empty");


        Node<T> tmp = first;
        first = first.next;
        if(first==null){
            last=null;
        }
        return tmp.element;

    }

    T peek() throws Exception {
        if(isEmpty())
            throw new Exception("Queue is Empty");

            return first.element;

    }


    // make sure first linkedList correct ?

    T remove() throws Exception {
        if(isEmpty())
            throw new Exception("Queue is Empty");


            Node<T> tmp = first;
            first = first.next;
            if(first==null){
                last=null;
            }
            return tmp.element;

    }

}
