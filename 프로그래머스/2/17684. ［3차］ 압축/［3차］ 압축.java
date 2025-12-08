import java.util.*;
class Solution {
    public int[] solution(String msg) {
       
        List<Integer> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int idx = 1;
        for (char c = 'A' ; c <= 'Z' ; c++) {
            map.put(String.valueOf(c), idx++);
        }
        int cur = 0;
        int n = msg.length();
        while(cur < n) {
            int j = cur + 1;
            
            while(j <= n && map.containsKey(msg.substring(cur,j))) {
                j++;
            }
            String w = msg.substring(cur,j - 1);
            list.add(map.get(w));
            if (j <= n) {
                String newStr = msg.substring(cur,j);
                map.put(newStr,idx++);
            }
            cur = j - 1;
        }
         int[] answer = new int[list.size()];
        for (int i = 0;i < list.size();i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}