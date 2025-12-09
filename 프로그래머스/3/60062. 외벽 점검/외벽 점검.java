import java.util.*;
class Solution {
    
    boolean [] used;
    int [] extend;
    int m;
    int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        
        
        m = weak.length;
        used = new boolean[dist.length];
        extend = new int[weak.length * 2];
        
        for (int i = 0; i < weak.length;i++) {
            extend[i] = weak[i];
            extend[i + weak.length] = weak[i] + n;
        }
        
        permute(new ArrayList<>(),dist);
        
        
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
    
    public void permute(List<Integer> order,int[] dist) {
        
        if (order.size() == dist.length) {
            check(order);
            return;
        }
        
        for (int i = 0; i < dist.length;i++) {
            if (used[i]) continue;
            used[i] = true;
            order.add(dist[i]);
            permute(order,dist);
            order.remove(order.size() - 1);
            used[i] = false;
        }
    }
    
    public void check(List<Integer> order) {
        for (int start = 0; start < m; start++) {
            int count = 1;
            int pos = extend[start] + order.get(0);
            int idx = start;
            
            while(idx < start + m) {
                if (pos >= extend[idx]) {
                    idx++;
                } else {
                    count++;
                    if (count > order.size()) {
                        break;
                    } 
                    pos = extend[idx] + order.get(count - 1);
                }
            }
            
            if (idx >= start + m) {
                min = Math.min(min,count);
            }
                
        }
    }
}