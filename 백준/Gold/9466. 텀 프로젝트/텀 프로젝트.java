import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int [] arr;
    static boolean [] visit;
    static boolean [] finish;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T;t++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visit = new boolean[n+1];
            finish = new boolean[n+1];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1;i <=n;i++) {
                if (!visit[i]) dfs(i);
            }

            sb.append(n - count).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int x) {
        visit[x] = true;
        int nxt = arr[x];
        if (!visit[nxt]) {
            dfs(nxt);
        } else if (!finish[nxt]) {
            count++;
            int cur = nxt;
            while(cur != x) {
                cur = arr[cur];
                count++;
            }
        }

        finish[x] = true;
    }
}