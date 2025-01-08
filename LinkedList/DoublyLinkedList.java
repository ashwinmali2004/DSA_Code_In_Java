package LinkedList;

class DoublyNode<T> {
    T data;
    DoublyNode next;
    DoublyNode prev;

    DoublyNode() {
        this.next = null;
        this.prev = null;
    }

    DoublyNode(T data) {
        this.next = null;
        this.prev = null;
        this.data = data;
    }
}

public class DoublyLinkedList {

    DoublyNode<Integer> head;
    DoublyNode<Integer> tail;
    int size;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList obj = new DoublyLinkedList();
        obj.insertTail(10);
        obj.printList();
        obj.insertHead(5);
        obj.insertTail(12);
        obj.printList();
        obj.printListInReverse();
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

    public void insertHead(int data) {
        DoublyNode<Integer> newNode = new DoublyNode<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            System.out.println("Insertion at head is successfull");
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        System.out.println("Insertion at head is successfull");
        size++;
    }

    public void insertTail(int data) {
        DoublyNode<Integer> newNode = new DoublyNode<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            System.out.println("Insertion at tail is successfull");
            size++;
            return;
        }
        DoublyNode<Integer> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        tail = newNode;
        System.out.println("Insertion at tail is successfull");
        size++;
    }

    public void insertNode(int data, int position) {
        if (position > size + 1 || position <= 0) {
            System.out.println("Wrong Input");
        }
        if (position == 1) {
            insertHead(data);
        } else if (position == size + 1) {
            insertTail(data);
        } else {
            int counter = 1;
            DoublyNode<Integer> newNode = new DoublyNode<>(data);
            DoublyNode<Integer> temp = head;
            while (counter < position - 1 && temp != null) {
                counter++;
                temp = temp.next;
            }
            DoublyNode<Integer> currNode = temp.next;
            newNode.next = currNode;
            currNode.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
            size++;
        }
        System.out.println("Insertion Successfull at position " + position);
    }

    public void printList() {
        DoublyNode<Integer> temp = head;
        System.out.println("Data is : --> ");
        while (temp != null) {
            System.out.println(temp.data + ",");
            temp = temp.next;
        }
    }

    public void printListInReverse() {
        DoublyNode<Integer> temp = tail;
        System.out.println("Data is : --> ");
        while (temp != null) {
            System.out.println(temp.data + ",");
            temp = temp.prev;
        }
    }

    public void deleteHead() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        DoublyNode<Integer> temp = head;
        head = temp.next;
        temp.next = null;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        System.out.println("Deletion at Head is Successful");
        size--;
    }

    public void deleteTail() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        // case for only one node in list
        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            System.out.println("Deletion at Head is successful");
            return;
        }
        DoublyNode<Integer> temp = head;
        DoublyNode<Integer> prevNode = null;
        while (temp.next != null) {
            prevNode = temp;
            temp = temp.next;
        }
        prevNode.next = null;
        temp.prev = null;
        tail = prevNode;
        System.out.println("Deletion at Tail is Successful");
        size--;
    }

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
            DoublyNode<Integer> prevNode = null;
            DoublyNode<Integer> temp = head;
            while(counter<position && temp!=null){
                counter++;
                prevNode = temp;
                temp=temp.next;
            }
            DoublyNode<Integer> nextNode = temp.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            temp.prev = null;
            temp.next = null;
            size--;
        }
        System.out.println("Deletion Successfull at position " + position);
    }

    public void updateNode(int position, int updateValue){
        if(head==null){
            System.out.println("Linked List is Empty");
            return;
        }
        int counter=1;
        DoublyNode<Integer> temp = head;
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

    public void search(int data) {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }

        int position = 1; 
        boolean found = false;
        DoublyNode<Integer> temp = head;

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