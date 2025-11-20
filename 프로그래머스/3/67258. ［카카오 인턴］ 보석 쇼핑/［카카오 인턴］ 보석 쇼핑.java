import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        int n = gems.length;
        
        HashSet<String> set = new HashSet<>();
        
        for (String g : gems) {
            set.add(g);
        }
        
        int kind = set.size();
        int left = 0;
        int minLen = n;
        int start = 0;
        int end = n- 1;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for (int right = 0 ; right < gems.length ; right++) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            while(map.size() == kind) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    start = left;
                    end = right;
                }
                
                int v = map.get(gems[left]);
                if (v == 1) {
                    map.remove(gems[left]);
                } else {
                    map.put(gems[left], v - 1);
                }
                
                left++;
                
            }
            
            
        }
        
        return new int[] {start + 1, end + 1};
    }
}