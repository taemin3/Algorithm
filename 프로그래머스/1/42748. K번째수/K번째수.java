import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int [] ans = new int[commands.length];
        
        for (int i = 0; i < commands.length ;i++) {
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];
            
            int [] arr = new int[b-a+1];
            
            for (int j = a;j <= b;j++) {
                arr[j - a] = array[j - 1];
            }
            Arrays.sort(arr);
            ans[i] = arr[c - 1];
        }
        return ans;
    }
}