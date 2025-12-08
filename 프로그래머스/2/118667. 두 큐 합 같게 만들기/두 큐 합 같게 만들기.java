import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n = queue1.length;
        long sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < n;i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        long total = sum1 + sum2;
        
        if (total % 2 != 0) return -1;
        
        long target = total / 2;
        
        while(sum1 != sum2) {
            if (answer > n * 3) return -1;
            if (sum1 > sum2) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
                answer++;
            } else {
                int num = q2.poll();
                sum1 += num;
                sum2 -= num;
                q1.offer(num);
                answer++;
            }
        }
        
        
        return answer;
    }
}