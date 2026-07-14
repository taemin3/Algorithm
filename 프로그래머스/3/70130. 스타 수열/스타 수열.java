class Solution {
    public int solution(int[] a) {
        int answer = -1;
        
        int [] cnt = new int[a.length];
        for (int val : a) {
            cnt[val]++;
        }
        int max = 0;
        
        for (int i = 0 ; i < a.length;i++) {
            if (cnt[i] <= max) continue;
            
            int ans = 0;
            for (int j = 0; j < a.length - 1;j++) {
                if (a[j] != a[j+1] && (a[j] == i || a[j+1] == i)) {
                    ans++;
                    j++;
                }
            }
            
            max = Math.max(max,ans);
        }
        
        
        
        return max*2;
    }
}