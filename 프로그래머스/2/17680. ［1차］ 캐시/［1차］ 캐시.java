import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> list = new LinkedList<>();
        int ans = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        for (int i = 0; i < cities.length ;i++) {
            String str = cities[i].toLowerCase();
            if (list.contains(str)) {
                int a = list.indexOf(str);
                list.remove(a);
                ans += 1;
                list.add(str);
            } else {
                if (list.size() >= cacheSize) {
                    list.removeFirst();
                }
                
                list.add(str);
                ans += 5;
            }
        }
        return ans;
    }
}