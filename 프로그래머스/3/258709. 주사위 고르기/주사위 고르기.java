import java.util.*;
class Solution {
    
    int n, k;
    boolean [] isA;
    int[] best;
    long bestWin = -1;
    int[][] dice;
    
    public int[] solution(int[][] dice) {
        this.dice = dice;
        int[] answer = {};
        
        n = dice.length;
        k = n / 2;
        
        isA = new boolean[n];
        best = new int[k];
        pick(0,0);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = best[i] + 1; // 1-index
        Arrays.sort(ans);
        return ans;
        
        
        
        
    }
    
    public void pick(int start, int cnt) {
        if (cnt == k) {
            int [] A = new int[k];
            int [] B = new int[k];
            int ai = 0, bi = 0;
            for (int i = 0; i <n;i++) {
                if(isA[i]) A[ai++] = i;
                else B[bi++] = i;
            }
            
            int size = 1;
            for (int i = 0; i < k;i++) size *= 6;
            int[] sumA = new int[size];
            int[] sumB = new int[size];
            fillSum(A,0,0,sumA,0);
            fillSum(B,0,0,sumB,0);
            
            Arrays.sort(sumB);
            
            long win = 0;
            for (int a : sumA) {
                win += wins(sumB,a);
            }
            
            if (win > bestWin || (win == bestWin && lexSmaller(A, best))) {
                bestWin = win;
                best = A.clone();
            }
            return;
        }
        
        
        for (int i = start ; i < n;i++) {
            isA[i] = true;
            pick(i + 1,cnt + 1);
            isA[i] = false;
        }
    }
    
    public int fillSum(int[] pick, int d, int sum, int [] out, int idx) {
        if (d == k) {
            out[idx] = sum;
            return idx + 1;
        }
        
        int die = pick[d];
        for (int i =0 ; i < 6;i++ ) {
            idx = fillSum(pick, d + 1, sum + dice[die][i], out, idx);
        }
        return idx;
    }
    
    public int wins(int[] arr, int target) {
        int answer = 0;
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (target > arr[mid]) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
       
    }
    
     public boolean lexSmaller(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return a[i] < b[i];
        }
        return false;
    }
    
    
}