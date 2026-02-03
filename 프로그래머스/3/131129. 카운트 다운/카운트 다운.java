class Solution {
    public int[] solution(int target) {
        int [][] dp = new int[target + 1][2];
        int INF = 1_000_000_000;
        
        for (int i = 0; i <= target;i++) {
            dp[i][0] = INF;
        }
        dp[0][0] = 0;
        
        for (int i = 1; i <= target;i++) {
            if (i - 50 >= 0 && dp[i - 50][0] != INF) {
                int dart = dp[i - 50][0] + 1;
                int sin = dp[i - 50][1] + 1;
                if (dart < dp[i][0]) {
                    dp[i][0] = dart;
                    dp[i][1] = sin;
                } else if (dart == dp[i][0]){
                        dp[i][1] = Math.max(dp[i][1],sin);
                    }
            }
            
            for (int j = 1;j <= 20;j++) {
                if (i - j >= 0 && dp[i-j][0] != INF) {
                    int dart = dp[i - j][0] + 1;
                    int sin = dp[i - j][1] + 1;
                    if (dart < dp[i][0]) {
                        dp[i][0] = dart;
                        dp[i][1] = sin;
                    } else if (dart == dp[i][0]){
                        dp[i][1] = Math.max(dp[i][1],sin);
                    }
                }
                
                if (i - j* 2 >= 0 && dp[i-j * 2][0] != INF) {
                    int dart = dp[i - j * 2][0] + 1;
                    int sin = dp[i - j * 2][1];
                    if (dart < dp[i][0]) {
                        dp[i][0] = dart;
                        dp[i][1] = sin;
                    } else if (dart == dp[i][0]){
                        dp[i][1] = Math.max(dp[i][1],sin);
                    }
                }
                
                if (i - j* 3 >= 0 && dp[i-j * 3][0] != INF) {
                    int dart = dp[i - j * 3][0] + 1;
                    int sin = dp[i - j * 3][1];
                    if (dart < dp[i][0]) {
                        dp[i][0] = dart;
                        dp[i][1] = sin;
                    } else if (dart == dp[i][0]){
                        dp[i][1] = Math.max(dp[i][1],sin);
                    }
                }
            }
        }
        
        return new int[]{dp[target][0],dp[target][1]};
    }
}