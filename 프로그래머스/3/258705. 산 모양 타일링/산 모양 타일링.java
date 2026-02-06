class Solution {
    public int solution(int n, int[] tops) {
        int [] dp1 = new int[n + 1];
        int [] dp2 = new int[n + 1];
        
        dp1[0] = 1;
        dp2[0] = 0;
        
        for (int i = 0;i < n;i++) {
            dp2[i + 1] = (dp1[i] + dp2[i]) % 10007;
            if (tops[i] == 1) {
                dp1[i+1] = ((dp1[i] * 3) + (dp2[i] *2)) % 10007;
            } else {
                dp1[i+1] = (dp1[i] * 2 + dp2[i]) % 10007; 
            }
        }
        return (dp1[n] + dp2[n]) % 10007;
    }
}