class Solution {
    
    public int solution(int n, int[] stations, int w) {
        int po = 1;
        int len = (w * 2) + 1;
        int answer = 0;
        
        for (int s : stations) {
            int left = s - w;
            if (po < left) {
                int gap = left - po;
                answer += (gap + len -1) /len;
            }
            po = s + w  + 1;
        }
        if (po <= n) {
            int gap = n - po + 1;
            answer += (gap + len - 1) /len;
        }
        return answer;
    }

}