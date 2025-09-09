package HPE;
import java.util.*;

public class MaxScoreOperations {

    public static long getMaximumScore(List<Integer> arr, int k) {
        // Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(arr);

        long score = 0;

        for (int i = 0; i < k; i++) {
            int top = maxHeap.poll();   // largest element
            score += top;
            int next = (int) Math.ceil(top / 3.0);  // replacement
            maxHeap.offer(next);
        }
        return score;
    }
}
