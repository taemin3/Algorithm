import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int [] parent;
    static int [] val;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        parent = new int[M + 1];
        val = new int[M];
        
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M ;i++) {
            parent[i] = i;
            val[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(val);

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < K ;i++) {
            int num = Integer.parseInt(st.nextToken());

            int lo = 0;
            int hi = M - 1;
            int ans = 0;
            
            while(lo <= hi) {
                int mid = (lo + hi) / 2;
                if (val[mid] > num) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            int idx = find(ans);
            sb.append(val[idx] + "\n");
            parent[idx] = find(idx + 1);
            
        }
        System.out.print(sb);
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}