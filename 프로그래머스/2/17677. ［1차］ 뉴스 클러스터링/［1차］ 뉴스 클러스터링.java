import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        int n = str1.length();
        int m = str2.length();
        
        String [] strA = new String[n - 1];
        String [] strB = new String[m - 1];
        
        Map<String,Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < n - 1;i++) {
            if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z' &&
               str1.charAt(i + 1) >= 'a' && str1.charAt(i + 1) <= 'z') {
             
                String a = ""+str1.charAt(i) + str1.charAt(i+1);
                
                map1.put(a,map1.getOrDefault(a,0) + 1);
            } else {
                continue;
            }
        }
        
        for (int i = 0; i < m - 1;i++) {
            if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z' &&
               str2.charAt(i + 1) >= 'a' && str2.charAt(i + 1) <= 'z') {
               
                String a = "" + str2.charAt(i) + str2.charAt(i+1);
                map2.put(a,map2.getOrDefault(a,0) + 1);
            } else {
                continue;
            }
        }
        
        int a = 0;
        int b = 0;
        
        for (String s: map1.keySet()) {
            if (map2.containsKey(s)) {
                int m1 = map1.get(s);
                int m2 = map2.get(s);
                
                if (m1 > m2) {
                    b += m1;
                    a += m2;
                } else {
                    a += m1;
                    b += m2;
                }
            } else {
                b += map1.get(s);
            }
        }
        
        for (String s : map2.keySet()) {
            if (!map1.containsKey(s)) {
                b += map2.get(s);
            }
        }
        
        if (a == 0 && b == 0) {
            return 65536;
        }
        
        
        double answer = (double) a / b;
        answer *= 65536;
        
        return (int) answer;
    }
}