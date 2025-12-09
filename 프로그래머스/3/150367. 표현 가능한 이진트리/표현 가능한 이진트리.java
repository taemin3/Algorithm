import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
    
        for (int i = 0 ; i < numbers.length;i++) {
            String str = Long.toBinaryString(numbers[i]);
            int len = str.length();
            
            int fullLen = 1;
            while(fullLen < len) {
                fullLen = fullLen * 2 + 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < fullLen - len; j++) {
                sb.append("0");
            }
            sb.append(str);
            boolean ok = check(sb.toString());
            answer[i] = ok ? 1 : 0;
        }    
        
        return answer;
    }
    
    public boolean check(String str) {
        int len = str.length();
        if (len == 1) {
            return true;
        }
        int mid = len / 2;
        char root = str.charAt(mid);
        
        String left = str.substring(0,mid);
        String right = str.substring(mid+1);
        
        if (root == '0') {
            if (one(left) || one(right)) return false;
        }
        return check(left) && check(right);
        
    }
    
    public boolean one(String str) {
        for (int i = 0; i < str.length();i++) {
            if(str.charAt(i) == '1') return true;
        }
        return false;
    }
    
    
    
    

}