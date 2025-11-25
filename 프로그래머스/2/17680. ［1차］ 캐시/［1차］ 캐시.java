import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        

        LinkedList<String> list = new LinkedList<>();
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        for (String c : cities) {
            c = c.toLowerCase();
            if (list.contains(c)) {
                answer += 1;
                list.remove(c);
                list.addFirst(c);
            } else {
                answer += 5;
                if (list.size() < cacheSize) {
                    list.addFirst(c);
                } else { 
                    list.removeLast();
                    list.addFirst(c);
                }
            }
        }
        
        return answer;
    }
}