import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] str = s.split(" ");
        int [] array = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(array);
        
        String answer = array[0] + " " + array[str.length - 1];
        return answer;
        
    }
}