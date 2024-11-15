package Queue;

public class MyCircularQueue {
    int capacity;
    int size;
    int circularqueue[];
    int rear;
    int front;

    public MyCircularQueue(int capacity){
        circularqueue = new int[capacity];
        this.capacity=capacity;
        size=0;
        rear=front=-1;
    }

    public boolean isFull(){
        if((front==0 && rear==capacity-1)||(front!=0 && rear==(front-1)%capacity)){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(front==-1){
            return true;
        }
        return false;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return circularqueue[front];
    }

    public void enqueue(int val){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }
        if(isEmpty()){
            front=0;
            rear=0;
        }else if(rear==capacity-1 && front!=0){
            rear=0;
        }else{
            rear++;
        }
        size++;
        circularqueue[rear]=val;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = circularqueue[front];
        if(front==rear){
            front=-1;
            rear=-1;
        }else if(front==capacity-1){
            front=0;
        }else{
            front++;
        }
        size--;
        return val;
    }

    public int size(){
        return size;
    }

    public void printQueue(){
        if (isEmpty()) {
            System.out.println("circularQueue is empty");
            return;
        }
        // circular case Printing
        if(rear<=front){
            for (int i = front; i <= capacity-1; i++) {
                System.out.print(circularqueue[i]);
                System.out.print(",");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(circularqueue[i]);
                if (i != rear) {
                    System.out.print(",");
                }
            }
        } else { // normal printing
            for (int i = front; i <= rear; i++) {
                System.out.print(circularqueue[i]);
                if (i != rear) {
                    System.out.print(",");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MyCircularQueue myQueue = new MyCircularQueue(5);
        System.out.println("Capacity is: "+5);
        System.out.println("Print:");
        myQueue.printQueue();
        System.out.println("Insert element :"+7);
        myQueue.enqueue(7);
        System.out.println("Peak element: "+ myQueue.peek());
        System.out.println("Insert element :"+8);
        myQueue.enqueue(8);
        System.out.println("Peak element: "+ myQueue.peek());
        System.out.println("Insert element :"+9);
        myQueue.enqueue(9);
        System.out.println("Peak element: "+ myQueue.peek());
        System.out.println("Insert element :"+11);
        myQueue.enqueue(11);
        System.out.println("Insert element :"+19);
        myQueue.enqueue(19);
        System.out.println("Insert element :"+9);
        myQueue.enqueue(9);
        System.out.println("is Queue full: "+ myQueue.isFull());
        System.out.println("Print:");
        myQueue.printQueue();
        System.out.println("delete element");
        myQueue.dequeue();
        System.out.println("is Queue full: "+ myQueue.isFull());
        System.out.println("Print:");
        myQueue.printQueue();
        System.out.println("Insert element :"+19);
        myQueue.enqueue(19);
        System.out.println("Print:");
        myQueue.printQueue();
        System.out.println("Peak element: "+ myQueue.peek());
        System.out.println("delete element");
        myQueue.dequeue();
        System.out.println("Peak element: "+ myQueue.peek());

        System.out.println("is Queue empty: "+ myQueue.isEmpty());

        System.out.println("Print:");
        myQueue.printQueue();
        System.out.println("delete element");
        myQueue.dequeue();
        System.out.println("delete element");
        myQueue.dequeue();
        System.out.println("delete element");
        myQueue.dequeue();
        System.out.println("delete element");
        myQueue.dequeue();
        System.out.println("is Queue empty: "+ myQueue.isEmpty());
        System.out.println("Print:");
        myQueue.printQueue();
        System.out.println("delete element");
        myQueue.dequeue();
    }
}
