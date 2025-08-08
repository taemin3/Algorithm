class Solution {
   
    public int solution(int n) {
        int answer = 0;
        boolean[] visit = new boolean[n+1];
        
        for (int i = 1; i <= n;i++) {
            int j = i;
            int sum = 0;
            while(sum < n) {
                
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
                j++;
            }                                                                                
        }
        return answer;
    }
    
    
}