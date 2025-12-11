import java.util.*;
class Solution {
    
    int[][] board;
    int n, m;
    int ans = Integer.MAX_VALUE;
    int [][] target;
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        n = beginning.length;
        m = beginning[0].length;
        board = new int[n][m];
        this.target = target;
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m;j++) {
                board[i][j] = beginning[i][j];
            }
        }
        dfs(0,0);
        
        return (ans == Integer.MAX_VALUE) ?  -1: ans;
    }
     
    public void flipRow(int c) {
        for (int j = 0; j < m;j++) {
            board[c][j] = (board[c][j] + 1) % 2;
        }
    }
    
    public int compare(int c) {
        int same = 0;
        for (int i = 0; i < n;i++) {
            if (board[i][c] == target[i][c]) same++;
        }
        
        if (same == n) {
            return 0;
        } else if (same == 0) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public void dfs(int r, int cnt) {
        
        if (r == n) {
            int total = cnt;
            for (int j = 0; j < m;j++) {
                int res = compare(j);
                if(res == -1) {
                    return;
                }
                total += res;
            }
            ans = Math.min(total, ans);
            return;
        }
        flipRow(r);
        dfs(r + 1, cnt +1);
        flipRow(r);
        
        dfs(r +1,cnt);
    }
}