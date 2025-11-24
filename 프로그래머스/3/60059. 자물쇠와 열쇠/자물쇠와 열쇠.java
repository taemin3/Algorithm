class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        int n = lock.length;
        int m = key.length;
        
        int [][] newLock = new int[n * 3][n * 3];
        
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < n;j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }
        
        for (int k = 0;k < 4;k++) {
            key = spin(key);
            for (int i = 0; i <= n * 3 - m;i++) {
                for (int j = 0;j <= n *3 - m;j++) {
                    
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m;y++) {
                            newLock[i+x][j+y] += key[x][y];
                        }
                    }
                    
                    if (check(newLock,n)) {
                        return true;
                    }
                    
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m;y++) {
                            newLock[i+x][j+y] -= key[x][y];
                        }
                    }
                    
                    
                }
            }
        }
        
        
        
        
        
        return false;
    }
    
    public int[][] spin(int[][] key) {
        int m = key.length;
        int [][] newKey = new int[m][m];
        
        for (int i = 0; i < m;i++) {
            for (int j = 0; j < m;j++) {
                newKey[j][m - 1 - i] = key[i][j];
            }
        }
        return newKey;
    }
    
    public boolean check(int[][] array, int n) {
        
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                if (array[i + n][j + n] != 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}