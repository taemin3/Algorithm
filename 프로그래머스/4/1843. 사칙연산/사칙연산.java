class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int n = arr.length / 2 + 1;
        int [][] dpMax = new int[n][n];
        int [][] dpMin = new int[n][n];
        
        for (int i = 0; i < n;i++) {
            
            dpMax[i][i] = Integer.parseInt(arr[i * 2]);
            dpMin[i][i] = Integer.parseInt(arr[i * 2]);
            
        }
        
        for (int len = 2; len <= n;len++) {
            for (int start = 0 ; start + len - 1 < n; start++) {
                int end = start + len - 1;
                dpMax[start][end] = Integer.MIN_VALUE;
                dpMin[start][end] = Integer.MAX_VALUE;
                for (int mid = start; mid < end; mid++) {
                    
                    int valMax;
                    int valMin;
                    if (arr[(mid*2)+1].equals("+")) {
                        int leftMax = dpMax[start][mid];
                        int rightMax = dpMax[mid+1][end];
                        valMax = leftMax + rightMax;
                        
                        int leftMin = dpMin[start][mid];
                        int rightMin = dpMin[mid+1][end];
                        valMin = leftMin + rightMin;
                    } else {
                        int leftMax = dpMax[start][mid];
                        int rightMax = dpMin[mid+1][end];
                        valMax = leftMax - rightMax;
                        
                        int leftMin = dpMin[start][mid];
                        int rightMin = dpMax[mid+1][end];
                        valMin = leftMin - rightMin;
                    }
                    dpMax[start][end] = Math.max(dpMax[start][end], valMax);
                    dpMin[start][end] = Math.min(dpMin[start][end], valMin);
                }
                
            }
        }
        
        return dpMax[0][n-1];
    }
}