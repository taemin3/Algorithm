import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int sum = 0;
        for (int i =  score.length - m; i >= 0 ; i -= m) {
        
            sum += score[i] * m;    
        }
        return sum;
    }
}