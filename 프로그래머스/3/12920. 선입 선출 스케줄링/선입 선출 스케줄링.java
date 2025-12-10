class Solution {
    public int solution(int n, int[] cores) {
        
        long low = 1;
        long high = cores.length * 10000;
        long anw = 0;
        while(low <= high) {
            long sum = cores.length;
            long mid = (low + high) / 2;
            for (int c : cores) {
                sum += mid/c;
            }
            if (sum >= n) {
                anw = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        long before = cores.length;
        for (int c : cores) {
            before += (anw - 1) / c;
        }
        long remain = n - before;
        
        for (int i = 0; i < cores.length;i++) {
            if (anw % cores[i] == 0) {
                remain--;
                if (remain == 0) return i + 1;
            }
        }
        
        return -1;
    }
}