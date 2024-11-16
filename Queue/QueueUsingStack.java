package Queue;

import java.util.*;

public class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int val){
        s1.push(val);
    }
    public int dequeue(){
        if(s1.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int val = s2.pop();

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return val;
    }

    public int peek(){
        if(s1.isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int val = s2.peek();

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return val;
    }

    public static void main(String[] args) {
        // Queue<Integer>queue = new LinkedList<>();
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Peek is " + queue.peek());
        System.out.println("DEQUEUE is " + queue.dequeue());
        queue.enqueue(7);
        System.out.println("Peek is " + queue.peek());
    }
}
