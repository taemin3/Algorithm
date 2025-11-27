class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int [][] acc = new int[n + 2][n + 2];
        
        
        for (int [] s : skill) {
            int type = s[0];
            int x1 = s[1];
            int y1 = s[2];
            int x2 = s[3];
            int y2 = s[4];
            int d = s[5];
            if (type == 1) d = -d;
            
            acc[x1][y1] += d;
            acc[x1][y2 + 1] -= d;
            acc[x2 + 1][y1] -= d;
            acc[x2 + 1][y2 + 1] += d;
        }
        
        for (int i =0; i <= n;i++) {
            for (int j = 1; j <= m ;j++) {
                acc[i][j] += acc[i][j - 1];
            }
        }
        
        for (int j = 0; j <= m;j++) {
            for (int i = 1; i <= n;i++) {
                acc[i][j] += acc[i - 1][j];
            }
        }
        
        
        
        
        
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < m;j++) {
                if (acc[i][j] + board[i][j] >= 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}