class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        
        int n = matrix_sizes.length;
        
        int [][] dp = new int[n][n];
        for (int len = 2;len <= n;len++) {
            for (int start = 0; start + len - 1< n;start++) {
                int end = start + len - 1;
                dp[start][end] = Integer.MAX_VALUE;
                for (int mid = start;mid < end;mid++) { 
                    int left = dp[start][mid];
                    int right = dp[mid+1][end];
                    int num = matrix_sizes[start][0] * matrix_sizes[mid][1] * matrix_sizes[end][1];
                    dp[start][end] = Math.min(dp[start][end],left+right+num);
                }
                
            }
            
        }
        
        return dp[0][n-1];
    }
}