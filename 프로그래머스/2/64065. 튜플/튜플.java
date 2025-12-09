import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2,s.length() - 2);
        String[] parts = s.split("\\},\\{");
        Arrays.sort(parts, (a,b) -> a.length() - b.length());
        
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (String p : parts) {
            String[] num = p.split(",");
            for (String n : num) {
                int x = Integer.parseInt(n);
                if (!set.contains(x) ) {
                    set.add(x);
                    list.add(x);
                }
            }
        }
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size() ;i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}