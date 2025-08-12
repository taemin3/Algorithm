import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int [] array = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0 ; i < prices.length ; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int num = stack.pop();
                array[num] = i - num; 
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int n = stack.pop();
            array[n] =  (prices.length-1) - n ;
        }
        return array;
    }    

}