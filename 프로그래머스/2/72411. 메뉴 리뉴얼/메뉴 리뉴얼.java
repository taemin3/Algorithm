import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < orders.length;i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }
        
        for (int c : course) {
            Map<String,Integer> map = new HashMap<>();
            
            for (String order: orders) {
                make(order, map, c, 0, new StringBuilder());
            }
            int max = 0;
            for (int cnt : map.values()) {
                max = Math.max(cnt,max);
            }
            
            if (max < 2) continue;
            
            for (Map.Entry<String,Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    list.add(entry.getKey());
                }
            }
        }
        Collections.sort(list);
        
         return list.toArray(new String[0]);
    }
    
    public void make(String order,Map<String,Integer> map,
                    int target, int idx, StringBuilder cur) {
        if (cur.length() == target) {
            String key = cur.toString();
            map.put(key,map.getOrDefault(key,0) + 1);
            return;
        }
        
        
        for (int i = idx; i < order.length();i++) {
            cur.append(order.charAt(i));
            make(order, map,target, i + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}