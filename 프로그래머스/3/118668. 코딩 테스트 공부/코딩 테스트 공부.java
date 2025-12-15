import java.util.*;

class Solution {
    static final int INF = 1_000_000_000;

    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;
        for (int[] p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }

        // 시작 능력이 이미 큰 경우 목표로 맞춰줌
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) Arrays.fill(dp[i], INF);
        dp[alp][cop] = 0;

        for (int a = alp; a <= maxAlp; a++) {
            for (int c = cop; c <= maxCop; c++) {
                int cur = dp[a][c];
                if (cur == INF) continue;

                // 공부 1) 알고력 +1
                if (a + 1 <= maxAlp) {
                    dp[a + 1][c] = Math.min(dp[a + 1][c], cur + 1);
                }
                // 공부 2) 코딩력 +1
                if (c + 1 <= maxCop) {
                    dp[a][c + 1] = Math.min(dp[a][c + 1], cur + 1);
                }

                for (int [] p : problems) {
                    if (a < p[0] || c < p[1]) continue;
                    
                    int na = Math.min(maxAlp, a + p[2]);
                    int nc = Math.min(maxCop, c + p[3]);
                    
                    dp[na][nc] = Math.min(dp[na][nc], cur + p[4]);
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}