/*
Queue Interface->
1. Front - deletion happens at the front end.
2. Rear - insertion happens at the rear end.

Using LinkedList class ->
1. queue.offer(element) //false in case of error //insert the element, 
    1.1 alternate is add() - throws exception if element can't be inserted
2. queue.poll(element) //null in case of error //delete the element, 
    2.1 alternate is remove() - throws exception if element can't be removed
3. queue.peek() //null in case of empty. //next element to see, 
    3.1 alternate is element() - throws exception

-> Priority Queue class
1. It is also a queue but with a priority and how do we implement it? using min heap(default).
-> Queue<Integer> minpq = new PriorityQueue<Integer>();
for max heap ->
-> Queue<Integer> maxpq = new PriorityQueue<Integer>(Comparator.reverseOrder());

Alternatively, you can write custom comparator in java.

-> using Dequeue Inteface ( Double ended queue )
Insertion and deletion, both can be performed at either ends.
Operations ->
1. peek(),
2. peekFirst()
3. peekLast()

4. poll()
5. pollFirst()
6. pollLast()

7. offer()
8. offerFirst()
9. offerLast()
*/


package CollectionFrameWorks;
import java.util.*;

public class BasicsQueue {
    public static void main(String[] args) {
        // In three ways we can implement the Queue-->

        // Queue<Integer> queue = new LinkedList<>();
        // Deque<Integer> queue = new ArrayDeque<>();
        // Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new comparator({
            new compare(int a, int b){
                return b-a;
            }
        }));

        queue.offer(1);
        queue.offer(15);
        queue.offer(7);
        queue.offer(2);

        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);

        // System.out.println( queue.offerFirst(9) );
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        // System.out.println( queue.offerLast(11) );
        System.out.println(queue);
        System.out.println(queue.peek());
        // System.out.println(queue.peekFirst());
        // System.out.println(queue.peekLast());

    }
}

