import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int [] box = Arrays.copyOf(order, order.length);
        Arrays.sort(box);
        int seq = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < box.length;i++) {
            if (box[i] == order[seq]) {
                answer++;
                seq++;
            } else {
                if (!stack.isEmpty() && stack.peek() == order[seq]) {
                    stack.pop();
                    answer++;
                    seq++;
                    while(true) {
                    if (!stack.isEmpty() && stack.peek() == order[seq]) {
                        stack.pop();
                        seq++;
                        answer++;

                    } else {
                        break;
                    }
        }
                }
                stack.push(box[i]);
            } 
        }
        
        
        while(true) {
            if (!stack.isEmpty() && stack.peek() == order[seq]) {
                stack.pop();
                seq++;
                answer++;
                
            } else {
                break;
            }
        }
        return answer;
    }
}