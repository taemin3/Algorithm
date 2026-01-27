import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long lo = 1;
        long hi = (long) times[times.length - 1] * n;
        long ans = hi;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            long count = 0;
            for (int t : times) {
                count += mid / t;
                if (count >= n) break; // 오버플로우/불필요 계산 방지
            }

            if (count >= n) {
                ans = mid;
                hi = mid - 1;  // 더 작은 시간으로 가능한지
            } else {
                lo = mid + 1;  // 시간이 부족
            }
        }

        return ans;
    }
}
