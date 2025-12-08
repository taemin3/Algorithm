class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {};
        return solve(arr,0,0,arr.length);
    }
    
    public int[] solve(int[][] arr, int x, int y , int size) {
        
        boolean same = true;
        int first = arr[x][y]; 
        for (int i = x; i < x + size;i++) {
            for (int j = y; j < y + size;j++) {
                if(first != arr[i][j]) {
                    same = false;
                    break;
                }
            }
            if(!same) break;
        }
        
        
        if (same) {
            if (first == 1) {
                return new int[]{0,1};
            } else {
                return new int[] {1,0};
            }
        }
        
        int half = size/2;
        int[] topLeft = solve(arr,x,y,half);
        int[] topRight = solve(arr,x, y+half,half);
        int[] botLeft = solve(arr,x+half,y,half);
        int[] botRight = solve(arr,x+half,y+half,half);
        
        int[] answer= new int[2];
        answer[0] = topLeft[0] + topRight[0] + botLeft[0] + botRight[0];
        answer[1] = topLeft[1] + topRight[1] + botLeft[1] + botRight[1];
        return answer;
    }
    
   
}