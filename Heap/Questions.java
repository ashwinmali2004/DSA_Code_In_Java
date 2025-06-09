package Heap;

import java.util.PriorityQueue;

public class Questions {
    public static void main(String[] args) {
        
    }
}

// leetcode -- 3170
class Solution {
    class Pair {
        char ch;
        int ind;
        Pair(char ch, int ind) {
            this.ch = ch;
            this.ind = ind;
        }
    }

    public String clearStars(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.ch != b.ch) {
                return Character.compare(a.ch, b.ch);
            }
            return Integer.compare(b.ind, a.ind);
        });

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '*') {
                pq.offer(new Pair(c, i));
            } else {
                Pair p = pq.poll();
                sb.setCharAt(p.ind, '*');
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '*') {
                ans.append(sb.charAt(i));
            }
        }
        return ans.toString();
    }
}
