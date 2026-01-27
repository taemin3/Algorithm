import java.util.*;

class Solution {
    static List<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        for (int i = 1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0 ; i <wires.length;i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0 ; i <wires.length;i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            int x = bfs(a,n);
            int y = bfs(b,n);
            int abs = Math.abs(x-y);
            ans = Math.min(ans,abs);
            graph[a].add(b);
            graph[b].add(a);
        }
        return ans;
    }
    
    public int bfs(int start, int n) {
        int count = 1;
        boolean [] visit = new boolean[n + 1];
        visit[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int g : graph[cur]) {
                if (visit[g]) continue;
                visit[g] = true;
                count++;
                q.offer(g);
            }
        }
        return count;
    }
    
}