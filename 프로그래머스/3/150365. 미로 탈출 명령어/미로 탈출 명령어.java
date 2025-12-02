import java.util.*;

class Solution {
    
  
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        int [] dx = {1,0,0,-1};
        int [] dy = {0,-1,1,0};
        String [] ds = {"d","l","r","u"};
        
        if (!can(x,y,r,c,k)) return "impossible";
        
        int curX = x;
        int curY = y;
        
        for (int i = 1; i <= k;i++) {
            
            for (int j = 0 ; j < 4;j++) {
                int nx = curX + dx[j];
                int ny = curY + dy[j];
                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                if (can(nx,ny,r,c,k - i)) {
                    curX = nx;
                    curY = ny;
                    answer += ds[j];
                    break;
                }
            }
            
        } 
        
        return answer;
    }
    
    public boolean can(int sx,int sy, int tx,int ty, int remain) {
        int dist = Math.abs(sx - tx) + Math.abs(sy - ty);
        if (dist > remain) return false;
        return (remain - dist) % 2 == 0;
    }
    
   
}