package Stack;
import java.util.*;

public class BasicsOfStack {
    int[] stack;
    int top;
    int size;

    public BasicsOfStack(int stackSize) {
        stack = new int[stackSize];
        size = stackSize;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1; 
    }

    public boolean isFull() {
        return top == size - 1; 
    }

    public void push(int element) {
        if (!isFull()) {
            top++; 
            stack[top] = element;
            System.out.println(element + " pushed to stack");
        } else {
            System.out.println("Stack is full");
        }
    }

    public void pop() {
        if (!isEmpty()) {
            System.out.println(stack[top] + " is popped");
            top--;
        } else {
            System.out.println("Stack is empty");
        }
    }

    public int size(){
        return top+1;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        return stack[top];
    }

    public void printStack(){
        System.out.println("Printing stack");
        for(int i=0;i<=top;i++){
            System.out.print(stack[i]);
            if(i!=top){
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the stack:");
        int n = sc.nextInt();

        BasicsOfStack stack = new BasicsOfStack(n);
        System.out.println("isEmpty:"+  stack.isEmpty());
        stack.push(9);
        stack.printStack();
        stack.push(1);
        stack.printStack();
        stack.push(8);
        stack.printStack();
        stack.push(5);
        stack.printStack();
        stack.push(8);
        stack.printStack();
        stack.push(2);
        stack.printStack();
        stack.push(6);
        stack.printStack();
        stack.pop();
        stack.printStack();
        System.out.println("size:"+  stack.size());
        System.out.println("isEmpty:"+  stack.isEmpty());
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        System.out.println("peek:"+  stack.peek());
    }
}
