class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = a[0];
        right[n - 1] = a[n-1];
        
        for (int i = 1; i < n;i++) {
            left[i] = Math.min(a[i],left[i - 1]);
            right[n - 1 - i] = Math.min(a[n - 1 - i], right[n - i]);
        }
        
        answer = 2;
        
        for (int i = 1; i < n - 1;i++) {
            if (a[i] > left[i] && a[i] > right[i]) {
                
            } else {
                answer++;
            }
        }
        return answer;
        
    }
}