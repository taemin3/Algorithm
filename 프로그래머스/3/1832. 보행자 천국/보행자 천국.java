import java.util.*;
class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        // [방향][X거리][Y거리]
        int[][][] dp = new int[2][m+1][n+1];
        
        //문제의 히든? 케이스 
        //무조건 최소거리
        //최소거리 이외의 거리는 없는것이나 마찬가지
        
        
        dp[0][0][0]=1;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(cityMap[i][j]==0){
                    //가로 진행
                    dp[0][i+1][j]+=(dp[0][i][j]+dp[1][i][j])%MOD;
                    //세로 진행
                    dp[1][i][j+1]+=(dp[0][i][j]+dp[1][i][j])%MOD;
                }
                else if(cityMap[i][j]==2){
                    //가로 진행
                    dp[0][i+1][j]+=dp[0][i][j];
                    dp[0][i+1][j]%=MOD;
                    //세로 진행
                    dp[1][i][j+1]+=dp[1][i][j];
                    dp[1][i][j+1]%=MOD;
                }
            }
        }
        
        return (dp[0][m-1][n-1]+dp[1][m-1][n-1])%MOD;
    }
    
    
}