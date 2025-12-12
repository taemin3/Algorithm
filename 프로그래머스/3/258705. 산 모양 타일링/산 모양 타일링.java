class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int [] dp0 = new int[n + 1];
        int [] dp1 = new int[n + 1];
        
        dp0[0] = 1;
        dp1[0] = 0;
        
        for (int i = 0 ; i < n; i++) {
            dp1[i + 1] = (dp0[i] + dp1[i]) % 10007;
            
            if (tops[i] == 1) {
                dp0[i+1] = ((dp0[i] * 3) + (dp1[i] * 2)) % 10007; 
            } else {
                dp0[i+1] = ((dp0[i] * 2) + dp1[i]) % 10007;
            }
        }
        
        return (dp0[n] + dp1[n]) % 10007;
    }
}