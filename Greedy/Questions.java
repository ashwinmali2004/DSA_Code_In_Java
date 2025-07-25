package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class Questions {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;

        ArrayList<Integer> indexArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexArr.add(i);
        }
    
        Collections.sort(indexArr, (a, b) -> finish[a] - finish[b]);
    
        int maxActivity = 1;
        int lastEnd = finish[indexArr.get(0)];
    
        for (int i = 1; i < n; i++) {
            int index = indexArr.get(i);
            if (start[index] > lastEnd) {
                maxActivity++;
                lastEnd = finish[index];
            }
        }
    
        return maxActivity;
    }
}
