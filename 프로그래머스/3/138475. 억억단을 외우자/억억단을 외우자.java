class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        
        int [] count = new int[e + 1];
        int [][] dp = new int[e + 1][2];
        for (int i = 1; i <= e;i++) {
            for (int j = i ; j <= e;j += i) {
                count[j]++;
            }
        }
        dp[e][0] = e;
        dp[e][1] = count[e];
        
        for (int i = e - 1; i >= 1;i--) {
            if (count[i] >= dp[i+1][1]) {
                dp[i][0] = i;
                dp[i][1] = count[i];
                
            } 
            else  {
                dp[i][0] = dp[i+1][0];
                dp[i][1] = dp[i+1][1];
            }
            
            
        }
        for (int i = 0; i < starts.length;i++) {
            answer[i] = dp[starts[i]][0];
        }
        
        return answer;
    }
}