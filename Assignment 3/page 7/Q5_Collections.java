// Write a generic class Stack<T> that can be used to represent stacks of objects of type T. The class
// should include methods push(), pop(), and isEmpty(). Inside the class, use an ArrayList to hold the
// items on the stack.

import java.util.ArrayList;

class Stack<T> {
    private ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack contents: " + stack);
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        
        System.out.println("Integer Stack Operations:");
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.display();
        System.out.println("Popped: " + intStack.pop());
        System.out.println("Is stack empty? " + intStack.isEmpty());
        intStack.display();

       
    }
}

/*
 
Output : 

Integer Stack Operations:
Stack contents: [10, 20, 30]
Popped: 30
Is stack empty? false
Stack contents: [10, 20]


*/