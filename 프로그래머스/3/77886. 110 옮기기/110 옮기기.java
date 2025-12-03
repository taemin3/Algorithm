import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0 ; i < s.length;i++) {
            answer[i] = solve(s[i]);
        }
        
        return answer;
    }
    
    public String solve(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder s110 = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n ;i++) {
            char c  = str.charAt(i);
            if (sb.length() >= 2 && c == '0' && sb.charAt(sb.length() - 1) == '1' &&
               sb.charAt(sb.length() - 2) == '1') {
                s110.append("110");
                sb.delete(sb.length() - 2, sb.length());
            } else {
                sb.append(c);
            }
        }
        
        if (s110.length() > 0) {
            if (sb.indexOf("0") == -1) {
                sb.insert(0,s110);
            } else {
                int i = sb.lastIndexOf("0");
                sb.insert(i + 1, s110);
            }
        }
        
        return sb.toString();
    }
}