import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int second = 0;
        int count = 0;
        int totalWeight = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length;i++) {
            q.add(0);
        }
        
        for (int i = 0;i < truck_weights.length;i++) {
            while(true) {
                answer++;
                totalWeight -= q.poll();
                if (totalWeight + truck_weights[i] <= weight) {
                    q.add(truck_weights[i]);
                    totalWeight += truck_weights[i];
                    
                    break;
                } else {
                    q.add(0);
                    
                }
            }
        }
        
        answer += bridge_length;
        
    
        
        return answer;
    }
}