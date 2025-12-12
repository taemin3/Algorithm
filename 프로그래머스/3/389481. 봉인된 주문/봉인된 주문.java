import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        long k = n;
        long[] ban = new long[bans.length];
        for (int i = 0 ; i < bans.length;i++) {
            ban[i] = num(bans[i]);
        }
        
        Arrays.sort(ban);
        
        for (long b : ban) {
            if (b <= k) {
                k++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(k > 0) {
            long r = (k - 1) % 26;
            sb.append((char) ('a' + r));
            k = (k - 1) / 26; 
        }
        return sb.reverse().toString();
    }
    
    public long num(String str) {
        long num = 0;
        for (int i = 0 ; i < str.length();i++) {
            int v = str.charAt(i) - 'a' + 1;
            num = num * 26 + v;
        }
        return num;
    }
}