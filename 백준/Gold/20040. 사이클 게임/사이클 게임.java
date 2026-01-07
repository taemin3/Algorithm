import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[] parent;

    static int find(int x) {
        if (parent[x] ==x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a,int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return false;
        parent[rb] = ra;
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n;i++) {
            parent[i] = i;
        }
        int ans = 0;
        for (int i = 1; i <= m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!union(a,b)) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);


        
        
    }

    

    
}