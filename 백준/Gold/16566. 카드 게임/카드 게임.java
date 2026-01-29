import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < M;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        parent = new int[M + 1];
        for (int i = 0;i <= M;i++) {
            parent[i] = i;
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < K;i++) {
            int a = Integer.parseInt(st.nextToken());
            int lo = 0;
            int hi = arr.length - 1;
            int idx = 0;
            while(lo <= hi) {
                int mid = (lo+hi) / 2;
                int l = arr[mid];
                if (l > a) {
                    idx = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            idx = find(idx);
            sb.append(arr[idx] + "\n");
            
            parent[idx] = find(idx + 1);
            
            
                
            
            
        }
        System.out.print(sb);

    }

    
}