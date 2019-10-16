package ds;

import dsInterface.Stack;

import java.util.ArrayList;

public class ListStack<X> implements Stack<X> {

    private ArrayList<X> data;
    private int stackpointer;

    public ListStack() {
        data = new ArrayList<X>();
        stackpointer = 0;
    }

    public void push(X newItem) {
        data.add(newItem);
        stackpointer++;
    }

    public X pop() {
       if(stackpointer == 0){
           throw new IllegalArgumentException("No more items on the stack");
       }
       return data.get(--stackpointer);
    }

    public boolean contains(X item) {
        boolean found = false;
        for(int i = 0; i < stackpointer; i++){
            if(data.get(i).equals(item)){
                found = true;
                break;
            }
        }
        return found;
    }

    public X access(X item) {
        while (stackpointer > 0){
             X tempItem = pop();
             if(item.equals(tempItem)){
                 return tempItem;
             }
        }
        throw new IllegalArgumentException("Stack doesn't have the item" + item);
    }

    public int size() {
        return stackpointer;
    }
}
