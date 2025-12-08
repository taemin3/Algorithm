import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int t = n;
        n = m;
        m = t;
        
        
        char [][] map = new char[n][m];
        
        for (int i = 0; i < n;i++ ){
            for (int j = 0;j < m;j++) {
                map[i] = board[i].toCharArray();
            }
        }
         
        while(true) {
             boolean [][] visit = new boolean[n][m];
        
        for (int i = 0 ; i < n - 1;i++) {
            for (int j = 0; j < m - 1; j++) {
                char c = map[i][j];
                if (c == '_') continue;
                if (map[i][j + 1] == c && map[i + 1][j] == c && 
                    map[i + 1][j + 1] == c) {
                    visit[i][j] = true;
                    visit[i+1][j] = true;
                    visit[i][j+1] = true;
                    visit[i+1][j+1] = true;
                }
            }
        }
        int remove = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m;j++) {
                if(visit[i][j]) {
                    map[i][j] = '_';
                    remove++;
                }
            }
        }
            if (remove== 0) break; 
            answer += remove;
            
        
        for (int j = 0; j < m;j++) {
            int r = n - 1;
            for (int i = n - 1; i >= 0 ; i--) {
                if (map[i][j] != '_') {
                    map[r][j] = map[i][j];
                    if (i != r) {
                        map[i][j] = '_';
                    }
                    r--;
                }
                
            }
         }
        }
       
        
        return answer;
    }
}