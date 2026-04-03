import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];

        for (int i = 0; i < N ;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int lo = 0;
        int hi = arr[N-1] - arr[0];
        int ans = 0;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if (can (arr,C,N,mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean can(int [] arr, int C, int N, int mid) {
        int cnt = 1;
        int idx = 0;
        for (int i = 1 ; i < N;i++) {
            if (arr[i] - arr[idx] >= mid) {
                idx = i;
                cnt++;
            }
            if (cnt >= C) {
                return true;
            }
        }
        return false;
        
    }

    
    
    
}