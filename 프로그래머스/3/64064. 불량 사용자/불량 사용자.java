import java.util.*;

class Solution {
    
    static Set<String> set;
    static int count = 0;
    static Set<Set<String>> result;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        set = new HashSet<>();
        result = new HashSet<>();
        
        dfs(user_id,banned_id, 0);
        return result.size();
    }
    
    public void dfs(String[] user_id, String[] banned_id, int depth) {
        
        if (depth == banned_id.length) {
            result.add(new HashSet<>(set));
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (set.contains(user_id[i])) {
                continue;
            }
            
            if (check(user_id[i], banned_id[depth])) {
                set.add(user_id[i]);
                dfs(user_id, banned_id, depth + 1);
                set.remove(user_id[i]);
            }
         }
        
        
        
    } 
    
    public boolean check(String user, String ban) {
        if (user.length() != ban.length()) {
            return false;
        }
        
        for (int i = 0 ; i < user.length(); i++) {
            if (ban.charAt(i) != '*' && user.charAt(i) != ban.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}