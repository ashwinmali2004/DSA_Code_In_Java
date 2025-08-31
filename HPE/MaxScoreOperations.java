package HPE;
import java.util.*;

public class MaxScoreOperations {

    public static long maximizeScore(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) pq.offer(num);

        int score = 0;

        while (!pq.isEmpty()) {
            int x = pq.poll();

            if (x <= 0) continue;
            int divideGain = (int) Math.ceil(x / 3.0);

            if (k >= divideGain) {
                score += k;
                x -= k;
            } else {
                score += divideGain;
                x = (int) Math.ceil(x / 3.0);
            }

            if (x > 0) pq.offer(x); 
        }

        return score;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15};
        int k = 4;
        System.out.println(maximizeScore(arr, k));
    }
}
