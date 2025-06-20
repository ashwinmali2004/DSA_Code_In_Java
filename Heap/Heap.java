package Heap;

import java.util.Arrays;

public class Heap {

    private int[] heap;
    private int size;
    private int capacity;
    private boolean isMinHeap; // To distinguish between Min-Heap and Max-Heap

    // Constructor for Heap
    public Heap(int capacity, boolean isMinHeap) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
        this.isMinHeap = isMinHeap;
    }

    // Helper functions to get the parent, left and right child indices
    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Helper function to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Function to heapify a subtree rooted with index i
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int extreme = i; // Assume root is the extreme value (min or max)

        if (isMinHeap) {
            if (left < size && heap[left] < heap[extreme]) {
                extreme = left;
            }
            if (right < size && heap[right] < heap[extreme]) {
                extreme = right;
            }
        } else {
            if (left < size && heap[left] > heap[extreme]) {
                extreme = left;
            }
            if (right < size && heap[right] > heap[extreme]) {
                extreme = right;
            }
        }

        if (extreme != i) {
            swap(i, extreme);
            heapify(extreme); // Recursive call to maintain the heap property
        }
    }

    // Function to build a heap from an array
    public void buildHeap(int[] arr) {
        this.size = arr.length;
        this.heap = Arrays.copyOf(arr, arr.length);
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // Function to insert an element into the heap
    public void insert(int key) {
        // if (size == capacity) {
        //     System.out.println("Overflow: Cannot insert element, heap is full.");
        //     return;
        // }
        if(size+1>=capacity){
            increaseCapacity();
        }

        heap[size] = key;
        size++;
        int i = size - 1;

        // Bubble up the newly inserted element to restore heap property
        while (i != 0 && (isMinHeap ? heap[parent(i)] > heap[i] : heap[parent(i)] < heap[i])) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Function to delete the root element (min or max)
    public int deleteRoot() {
        if (size <= 0) {
            System.out.println("Underflow: Heap is empty.");
            return Integer.MIN_VALUE; // or Integer.MAX_VALUE for min/max heap
        }
        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0); // Restore heap property
        return root;
    }

    // Function to increase the key at index i (used in Max-Heap)
    public void increaseKey(int i, int newValue) {
        if (isMinHeap) {
            System.out.println("increaseKey is not applicable for Min-Heap.");
            return;
        }
        if (newValue < heap[i]) {
            System.out.println("New value is smaller than the current value.");
            return;
        }

        heap[i] = newValue;
        while (i != 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Function to decrease the key at index i (used in Min-Heap)
    public void decreaseKey(int i, int newValue) {
        if (!isMinHeap) {
            System.out.println("decreaseKey is not applicable for Max-Heap.");
            return;
        }
        if (newValue > heap[i]) {
            System.out.println("New value is greater than the current value.");
            return;
        }

        heap[i] = newValue;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Function to perform heap sort
    public void heapSort() {
        int originalSize = size;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }

        for (int i = size - 1; i >= 1; i--) {
            swap(0, i);
            size--;
            heapify(0);
        }

        size = originalSize; // Restore the original size
    }

    // Function to print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Function to check if the heap is a complete binary tree
    public boolean isCompleteTree() {
        return isCompleteTree(0);
    }

    private boolean isCompleteTree(int i) {
        if (i >= size) return true; // Out of bounds, no children here
        int left = leftChild(i);
        int right = rightChild(i);

        // Check if both left and right children are complete
        return (left >= size || heap[i] <= heap[left]) && (right >= size || heap[i] <= heap[right]) &&
                isCompleteTree(left) && isCompleteTree(right);
    }

    public void increaseCapacity(){
        capacity *= 2; //double the size
        int newHeap[] = new int[capacity];
        for(int i=0;i<size;i++){
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    // Driver function to test the heap functionalities
    public static void main(String[] args) {
        // Create a Min-Heap with a capacity of 10
        Heap minHeap = new Heap(10, true);

        System.out.println("Building Min-Heap from array:");
        int[] arr = {4, 10, 3, 5, 1};
        minHeap.buildHeap(arr);
        minHeap.printHeap();

        System.out.println("Inserting 2 into Min-Heap:");
        minHeap.insert(2);
        minHeap.printHeap();

        System.out.println("Deleting root of Min-Heap:");
        minHeap.deleteRoot();
        minHeap.printHeap();

        System.out.println("Decrease key (index 3, value 1):");
        minHeap.decreaseKey(3, 1);
        minHeap.printHeap();

        System.out.println("Heap sort:");
        minHeap.heapSort();
        minHeap.printHeap();

        // Create a Max-Heap with a capacity of 10
        Heap maxHeap = new Heap(10, false);

        System.out.println("\nBuilding Max-Heap from array:");
        maxHeap.buildHeap(new int[]{4, 10, 3, 5, 1});
        maxHeap.printHeap();

        System.out.println("Inserting 12 into Max-Heap:");
        maxHeap.insert(12);
        maxHeap.printHeap();

        System.out.println("Increase key (index 2, value 6):");
        maxHeap.increaseKey(2, 6);
        maxHeap.printHeap();

        System.out.println("Deleting root of Max-Heap:");
        maxHeap.deleteRoot();
        maxHeap.printHeap();

        System.out.println("Is Max-Heap a complete tree? " + maxHeap.isCompleteTree());
    }
}