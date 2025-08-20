import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);      // 오름차순
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;           // 현재 위치에서의 후보 H
            if (citations[i] >= h) { // 인용수가 h 이상인 논문이 h편 이상인가?
                return h;            // 가장 큰 h부터 만족하게 되므로 즉시 반환
            }
        }
        return 0;
    }
}