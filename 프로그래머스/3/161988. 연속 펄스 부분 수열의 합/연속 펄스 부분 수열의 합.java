class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        
        long sum1 = 0;
        long sum2 = 0;
        
       for (int i = 0 ; i < sequence.length;i++) {
           long val = sequence[i];
           
           long p1 = (i % 2 == 0) ? val : -val;
           long p2 = -p1;
           
           sum1 = Math.max(p1, sum1 + p1);
           sum2 = Math.max(p2, sum2 + p2);
           
           answer = Math.max(answer,Math.max(sum1,sum2));
       }
        
        return answer;
    }
    
    
}