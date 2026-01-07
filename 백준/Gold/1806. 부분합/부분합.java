import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            
        }
        
        long sum = 0;
        int ans = Integer.MAX_VALUE;

        int l = 0;

        for (int r = 0; r < N ; r++) {
            sum += arr[r];
            while(sum >= S) {
                ans = Math.min(ans,r - l + 1);
                sum -= arr[l];
                l++;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
        
        
    }
}