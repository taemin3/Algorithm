import java.util.*;
class Solution {
    boolean [][] ki;
    boolean [][] bo;
    int size;
    
    public int[][] solution(int n, int[][] build_frame) {
        
        
        ki = new boolean[n + 1][n + 1];
        bo = new boolean[n + 1][ n + 1];
        size = n;
        for (int [] bf : build_frame) {
            int x = bf[0];
            int y = bf[1];
            int a = bf[2];
            int b = bf[3];
            if (a == 0) {
                if (b == 1) {
                    ki[x][y] = true;
                    if(!isValid()) {
                        ki[x][y] = false;
                    }
                } else {
                    ki[x][y] = false;
                    if(!isValid()) {
                        ki[x][y] = true;
                    }
                }
            } else {
                if (b == 1) {
                    bo[x][y] = true;
                    if(!isValid()) {
                        bo[x][y] = false;
                    }
                } else {
                    bo[x][y] = false;
                    if(!isValid()) {
                        bo[x][y] = true;
                    }
                }
            }
        }
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i <= n;i++){
            for (int j = 0;j <= n;j++) {
                if (bo[i][j]) list.add(new int[] {i,j,1});
                if (ki[i][j]) list.add(new int[] {i,j,0});
            }
        }
        Collections.sort(list, (a,b) -> {
            if (a[0] == b[0] && a[1] == b[1]) return a[2] - b[2];
            if (a[0] == b[0] ) return a[1] - b[1];
            return a[0] - b[0];
        });
        int[][] answer = new int[list.size()][3];
        for (int i = 0 ; i < list.size();i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private boolean isValid() {
        for (int x = 0; x <= size; x++) {
            for (int y = 0; y <= size; y++) {
                if (ki[x][y]) {
                    if (!canKi(x, y)) return false;
                }
                if (bo[x][y]) {
                    if (!canBo(x, y)) return false;
                }
            }
        }
        return true;
    }
    
    public boolean canKi(int x , int y) {
        if (y == 0) return true;
        if (y > 0 && ki[x][y - 1]) return true;
        if (x > 0 && bo[x - 1][y]) return true;
        if (bo[x][y]) return true;
        return false;
    }
    
    public boolean canBo(int x,int y) {
        if (y > 0 && ki[x][y-1]) return true;
        if (y > 0 && x + 1 <= size && ki[x + 1][y-1]) return true;
        if (x > 0 && x + 1<= size && bo[x-1][y] && bo[x + 1][y]) return true;
        return false;
    }
}