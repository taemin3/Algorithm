import java.util.*;

class Solution {
    
    ArrayList<Integer> [] list;
    static boolean [] visit;
    static int [] dist;
     
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        dist = new int[n + 1];
        list = new ArrayList[n + 1];
        
        for (int i = 1; i <= n ; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < roads.length ; i++) {
            list[roads[i][0]].add(roads[i][1]);
            list[roads[i][1]].add(roads[i][0]);
        }
        
        Arrays.fill(dist, -1);
        visit = new boolean[n + 1];
       bfs(destination);
        
        for (int i = 0 ; i < sources.length ; i++) {
            answer[i] = dist[sources[i]];
        }
        
        
        
        
        return answer;
    }
    
    public void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visit[start] = true;
        dist[start] = 0;
        
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            for (int a : list[cur[0]]) {
                if (!visit[a]) {
                    visit[a] = true;
                    dist[a] = cur[1] + 1;
                    q.offer(new int[] {a, cur[1] + 1});
                }
            }
        }
        
    }
}