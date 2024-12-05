package CollectionFrameWorks;
import java.util.*;

public class BasicsQueue {
    public static void main(String[] args) {
        // In three ways we can implement the Queue-->

        // Queue<Integer> queue = new LinkedList<>();
        // Deque<Integer> queue = new ArrayDeque<>();

        // There are three methods to represent the PriorityQueue-->
        // Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        // PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer a, Integer b) {
        //         return b - a; // For max-heap behavior
        //     }
        // });

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));

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

