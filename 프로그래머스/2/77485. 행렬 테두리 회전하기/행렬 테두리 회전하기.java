class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int count = 1;
        int [][] map = new int[rows][columns];
        for (int i = 0;i < rows;i++) {
            for (int j = 0; j < columns ;j++) {
                map[i][j] = count++;
            }
        }
        int idx = 0;
        for (int [] q : queries) {
            int x1 = q[0] - 1;
            int y1 = q[1] - 1;
            int x2 = q[2] - 1;
            int y2 = q[3] - 1;
            int tmp = map[x1][y1];
            int min = tmp;
            
            for (int i = x1; i < x2;i++) {
                map[i][y1] = map[i+1][y1];
                min = Math.min(min,map[i][y1]);
            }
            
            for (int i = y1; i < y2;i++) {
                map[x2][i] = map[x2][i+1];
                min = Math.min(min,map[x2][i]);
            }
            
            for (int i = x2; i > x1;i--) {
                map[i][y2] = map[i-1][y2];
                min = Math.min(min,map[i][y2]);
            }
            
            for (int i = y2; i > y1 + 1;i--) {
                map[x1][i] = map[x1][i-1];
                min = Math.min(min,map[x1][i]);
            }
            map[x1][y1+1] = tmp; 
            answer[idx++] = min;
        }
        
        return answer;
    }
}