import java.util.*;

class Solution {
    public int solution(int[] order) {
        int n = order.length;
        int answer = 0;
        int seq = 0;                 // order에서 다음에 실어야 할 인덱스
        Stack<Integer> stack = new Stack<>();

        for (int box = 1; box <= n; box++) {
            stack.push(box);         // 컨베이어에서 상자 하나 옮김

            // 스택 맨 위가 원하는 순서와 같다면 가능한 만큼 계속 꺼낸다
            while (!stack.isEmpty()  && stack.peek() == order[seq]) {
                stack.pop();
                answer++;
                seq++;
            }
        }

        return answer;
    }
}