import java.util.*;
class Solution {
    
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        int n = enroll.length;
        
        HashMap<String, Integer> idx = new HashMap<>();
        for (int i = 0 ; i < n; i++) {
            idx.put(enroll[i], i);
        }
        
        int[] parent = new int[n];
        
        for (int i = 0 ; i < n;i++) {
            if (referral[i].equals("-")) {
                parent[i] = -1;
            } else { 
                parent[i] = idx.get(referral[i]);
            }
        }
        int m = seller.length;
        int [] money = new int[n];
        for (int i = 0 ; i < m ; i++) {
            int a = idx.get(seller[i]);
            int don = amount[i] * 100;
            
            int cur = a;
            
            while(cur != -1 && don > 0) {
                int m1 = don / 10;
                int m2 = don - m1;
                
                money[cur] += m2;
                cur = parent[cur];
                don = m1;
            }
        }
       
        return money;
    }
}