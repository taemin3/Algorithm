class Solution {
 
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = -1;
        long minX = x;
        long maxX = x;
        long minY = y;
        long maxY = y;
        for (int i = queries.length - 1; i >= 0;i--) {
            int d = queries[i][0];
            int val = queries[i][1];
            if (d == 0) {
                if (minY != 0) {
                    minY += val;
                }
                maxY = Math.min(m - 1, maxY + val);
            } else if (d == 1) {
                if (maxY != m - 1) {
                    maxY -= val;
                }
                minY = Math.max(0, minY - val);
            } else if (d == 2) {
                if (minX != 0) {
                    minX += val;
                }
                maxX = Math.min(n - 1, maxX + val);
            } else if (d == 3) {
                if (maxX != n - 1) {
                    maxX -= val;
                }
                minX = Math.max(0, minX - val);
            }
            
            if (minX > maxX || minY > maxY) return 0;
            if (minX >= n || maxX < 0 || minY >= m || maxY < 0) return 0;
            
            
        }
        long ansX = maxX - minX + 1;
        long ansY = maxY - minY + 1;
        return ansX * ansY;
        
    
        
    }
    
    
}