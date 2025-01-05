package LinkedList;

class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.next = null;
        this.data = data;
    }
}

public class BasicLinkedList{
    Node<Integer> head;
    int size;
    BasicLinkedList(){
        this.head = null;
        this.size = 0;
    }
    public static void main(String[] args) {
        BasicLinkedList obj = new BasicLinkedList();
        obj.insertTail(10);
        obj.printList();
        obj.insertHead(5);
        obj.insertTail(12);
        obj.printList();
        obj.insertNode(4, 2);
        obj.printList();
        obj.deleteTail();
        obj.printList();
        obj.deleteNode(2);
        obj.printList();
        obj.updateNode(1, 2);
        obj.printList();
        obj.search(10);
    }

    // insert At Fist Position
    public void insertHead(int data){
        Node<Integer> newNode = new Node<>(data);
        if(head==null){
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Insertion At Head is Successful");
    }

    // insert at the tail
    public void insertTail(int data){
        Node<Integer> newNode = new Node<>(data);
        if(head==null){
            head = newNode;
            size++;
            return;
        }
        Node<Integer> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        size++;
        System.out.println("Insertion At Tail is Successful");
    }

    // insert Node at any specific position
    public void insertNode(int data, int position){
        if(position>size+1 || position<=0){
            System.out.println("Wrong Input");
        }
        if(position == 1){
            insertHead(data);
        }else if(position == size+1){
            insertTail(data);
        }else{
            int counter = 1;
            Node<Integer> newNode = new Node<>(data);
            Node<Integer> temp = head;
            while(counter<position-1 && temp!=null){
                counter++;
                temp=temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
        System.out.println("Insertion Successfull at position " + position);
    }

    // To Print my List
    public void printList(){
        Node<Integer> temp = head;
        System.out.println("Data is : --> ");
        while(temp!=null){
            System.out.println(temp.data + ",");
            temp=temp.next;
        }
    }

    // Delete node at Head
    public void deleteHead(){
        if(head==null){
            System.out.println("Linked list is empty");
            return;
        }
        Node<Integer> temp = head;
        head = head.next;
        temp.next = null;
        System.out.println("Deletion at Head is Successful");
        size--;
    }

    // Delete node at tail
    public void deleteTail(){
        // case for empty list 
        if(head==null){
            System.out.println("Linked list is empty");
            return;
        }

        // case for only one node in list
        if(head.next == null){
            head = null;
            size--;
            System.out.println("Deletion at Head is successful");
            return;
        }
        Node<Integer> temp = head;
        Node<Integer> prev = null;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        System.out.println("Deletion at Tail is Successful");
        size--;
    }

    // Delete node at position
    public void deleteNode(int position){
        if(position>size || position<=0){
            System.out.println("Wrong Input");
            return;
        }
        if(position == 1){
            deleteHead();
        }else if(position == size){
            deleteTail();
        }else{
            int counter = 1;
            Node<Integer> prev = null;
            Node<Integer> temp = head;
            while(counter<position && temp!=null){
                counter++;
                prev = temp;
                temp=temp.next;
            }
            prev.next=temp.next;
            temp.next = null;
            size--;
        }
        System.out.println("Deletion Successfull at position " + position);
    }

    // Delete By Value
    public void deleteValue(int data) {
        // Handle empty list
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        // Handle deletion of head node(s)
        while (head != null && head.data == data) {
            head = head.next;
            size--;
        }

        Node<Integer> temp = head;
        Node<Integer> prev = null;

        while (temp != null) {
            if (temp.data == data) {
                prev.next = temp.next;
                size--; 
            } else {
                prev = temp;
            }
            temp = temp.next;
        }

        System.out.println("Deletion of value " + data + " completed.");
    }

    // Update the Value
    public void updateNode(int position, int updateValue){
        if(head==null){
            System.out.println("Linked List is Empty");
            return;
        }
        int counter=1;
        Node<Integer> temp = head;
        while(counter<position & temp!=null){
            counter++;
            temp=temp.next;
        }
        if(temp!=null && counter==position){
            temp.data=updateValue;
        }else{
            System.out.println("Size of Linked List is smaller than position "+ position);
            return;
        }
        System.out.println("Update at the position is Successful "+position);
    }

    // Search for specific number and return the position(s)
    public void search(int data) {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }

        int position = 1; 
        boolean found = false;
        Node<Integer> temp = head;

        System.out.print("Available at position(s): ");
        while (temp != null) {
            if (temp.data == data) {
                found = true;
                System.out.print(position + " "); 
            }
            temp = temp.next; 
            position++;
        }

        if (!found) {
            System.out.println("Not Available");
        } else {
            System.out.println();
        }
    }

}