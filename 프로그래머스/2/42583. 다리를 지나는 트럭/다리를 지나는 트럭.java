import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
       Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0 ; i < bridge_length;i++) {
            q.offer(0);
        }
        int total = 0;
        int ans = 0;
        
        for (int i = 0 ; i < truck_weights.length ;i++) {
            while(true) {
                ans++;
                int n = q.poll();
                total -= n;
                if (total + truck_weights[i] <= weight) {
                    q.offer(truck_weights[i]);
                    total += truck_weights[i];
                    break;
                } else {
                    q.offer(0);
                }
            }
        }
        ans += bridge_length;
        return ans;
    }
}