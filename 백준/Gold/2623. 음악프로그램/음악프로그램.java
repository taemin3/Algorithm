import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N;i++) {
            graph[i] = new ArrayList<>();
        }
        int [] indeg = new int[N+1];
        for (int i = 0 ; i <  M ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int [] array = new int[n];
            for (int j = 0; j < n;j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < n - 1;j++) {
                int a = array[j];
                int b = array[j+1];
                graph[a].add(b);
                indeg[b]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1;i <= N;i++) {
            if (indeg[i] == 0) q.offer(i);
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            int cur = q.poll();
            list.add(cur);
            for (int c :  graph[cur]) {
                indeg[c]--;
                if (indeg[c] == 0) {
                    q.offer(c);
                }
            }
            
            
        }
        if (list.size() == N) {
            for (int i = 0; i < N;i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println(0);
        }
    }
}