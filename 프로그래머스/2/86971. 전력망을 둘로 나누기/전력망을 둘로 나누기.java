import java.util.*;

class Solution {
    static boolean[] visit;
    static int[][] array;
    static int count;
    public int solution(int n, int[][] wires) {
        int min = 100;
        int answer = -1;
        count = 0;
        array = new int[n+1][n+1];
        visit = new boolean[n+1];
        for (int i = 0; i < n - 1;i++) {
            array[wires[i][0]][wires[i][1]] = 1;
            array[wires[i][1]][wires[i][0]] = 1;
        }
        for (int i = 0;i < n - 1;i++) {
            int result = 0;
            
            array[wires[i][0]][wires[i][1]] = 0;
            array[wires[i][1]][wires[i][0]] = 0;
            for (int j = 1;j <= n;j++) {
                if(!visit[j]) {
                    dfs(j,n);
                    if (result == 0) {
                        result = count;
                    } else {
                        if(result > count) {
                            result -= count;
                        } else {
                            result = count - result;
                        }
                    }
                    count = 0;
                }
            }
            if (result < min) {
                min = result;
            }
            array[wires[i][0]][wires[i][1]] = 1;
            array[wires[i][1]][wires[i][0]] = 1;
            Arrays.fill(visit, false);
            
        }
        return min;
    }
    
    public static void dfs(int start,int n) {
        count++;
        visit[start] = true;
        for (int i = 1; i <= n;i++) {
            if (array[start][i] == 1 && !visit[i]) {
                
                dfs(i,n);
            }
        }
    }
}