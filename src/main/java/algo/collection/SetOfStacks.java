package algo.collection;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks <T extends Comparable<T>>{


    // push,pop,peek
    List<Stack<T>> stacksList = new ArrayList<>();

    public static final int CAPACITY = 10;




    void push(T element){
        if(stacksList.get(stacksList.size()-1).size()==CAPACITY|| stacksList.isEmpty()){
            stacksList.add(new Stack<>());
        }
        stacksList.get(stacksList.size()-1).push(element);
    }

    T pop() throws Exception {
        if(stacksList.isEmpty()){
            throw new Exception("Empty Stack");
        }
        if(stacksList.get(stacksList.size()-1).isEmpty()){
            stacksList.remove(stacksList.size()-1);
        }
        return stacksList.get(stacksList.size()-1).pop();
    }

/*    T popAt(int index){
        //
    }*/
}
