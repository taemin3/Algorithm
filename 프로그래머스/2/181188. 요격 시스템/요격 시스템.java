import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        for (int [] t : targets) {
            pq.offer(new int[]{t[0],t[1]});
        }
        
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int a = cur[0];
            int b = cur[1];
            while(!pq.isEmpty() && b > pq.peek()[0]) {
                
                pq.poll();
                
            }
            answer++;
        }
        
        return answer;
    }
}