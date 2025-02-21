package Tree;

import java.util.*;

class NewStudent implements Comparable<NewStudent>{
    int marks;
    String name;
    NewStudent(String name, int marks){
        this.name = name;
        this.marks = marks;
    }
    @Override
    public String toString(){
        return "Student name: " + this.name + " , "+this.marks;
    }
    @Override
    public int compareTo(NewStudent that) {
        // return this.marks-that.marks;  //increasing order
        if(that.marks == this.marks){
            return this.name.compareTo(that.name);
        }
        return that.marks-this.marks;  //decreasing order
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof NewStudent){
            NewStudent that = (NewStudent) obj;
            boolean isNameSame = (this.name.compareTo(that.name))==0;
            if(this.marks == that.marks && isNameSame){
                return true;
            }
        }
        return false;
    }
}

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Min-Heap (Default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Max-Heap using Collections.reverseOrder()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Insert elements
        minHeap.offer(10);
        minHeap.offer(5);
        minHeap.offer(20);
        minHeap.offer(15);

        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(20);
        maxHeap.offer(15);

        System.out.println("Min-Heap (Ascending Order): " + minHeap);
        System.out.println("Max-Heap (Descending Order): " + maxHeap);

        // Peek (Retrieve the top element without removing)
        System.out.println("Min-Heap Peek: " + minHeap.peek());
        System.out.println("Max-Heap Peek: " + maxHeap.peek());

        // Poll (Remove the top element)
        System.out.println("Min-Heap Poll: " + minHeap.poll());
        System.out.println("Max-Heap Poll: " + maxHeap.poll());

        // After Poll
        System.out.println("Min-Heap after poll: " + minHeap);
        System.out.println("Max-Heap after poll: " + maxHeap);

        // Contains (Check if an element is present)
        System.out.println("Min-Heap contains 15? " + minHeap.contains(15));
        System.out.println("Max-Heap contains 5? " + maxHeap.contains(5));

        // Remove an element
        minHeap.remove(20);
        maxHeap.remove(5);

        System.out.println("Min-Heap after removing 20: " + minHeap);
        System.out.println("Max-Heap after removing 5: " + maxHeap);

        // Convert to Array
        Object[] minHeapArray = minHeap.toArray();
        Object[] maxHeapArray = maxHeap.toArray();

        System.out.println("Min-Heap as Array: " + Arrays.toString(minHeapArray));
        System.out.println("Max-Heap as Array: " + Arrays.toString(maxHeapArray));

        // Size
        System.out.println("Min-Heap Size: " + minHeap.size());
        System.out.println("Max-Heap Size: " + maxHeap.size());

        // Iterate over elements
        System.out.print("Min-Heap Elements: ");
        for (Integer num : minHeap) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Max-Heap Elements: ");
        for (Integer num : maxHeap) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Clear the PriorityQueue
        minHeap.clear();
        maxHeap.clear();

        System.out.println("Min-Heap after clear(): " + minHeap);
        System.out.println("Max-Heap after clear(): " + maxHeap);

        PriorityQueue<NewStudent> minStudentPq = new PriorityQueue<>();
        NewStudent ns = new NewStudent("Ashwin", 80);
        minStudentPq.offer(new NewStudent("Ashwin", 80));
        minStudentPq.offer(new NewStudent("aman", 70));
        minStudentPq.offer(new NewStudent("rohit", 90));
        minStudentPq.offer(new NewStudent("mohit", 90));
        System.out.println(minStudentPq.peek());

        // send the object for checking the existance
        System.out.println(minStudentPq.contains(ns));
    }
}

