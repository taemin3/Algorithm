import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int n = jobs.length;
        int cur = 0;
        int idx = 0;
        int sum = 0;
        while(idx < n || !pq.isEmpty()) {
            while (idx < n && cur >= jobs[idx][0]) {
                pq.offer(new int[]{jobs[idx][0],jobs[idx][1]});
                idx++;
            }
            if (!pq.isEmpty()) {
                int [] temp = pq.poll();
                cur += temp[1];
                sum += cur - temp[0];
            } else {
                cur++;
            }
        }
        return sum/n;
        
    }
}