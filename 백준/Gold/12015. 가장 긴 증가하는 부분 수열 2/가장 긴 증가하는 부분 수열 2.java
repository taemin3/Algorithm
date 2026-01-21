import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        int [] lis = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        lis[0] = arr[0];
        int idx = 1;

        for (int i = 1 ; i < N;i++) {
            if (lis[idx - 1] < arr[i]) {
                lis[idx++] = arr[i];
            } else {
                int lo = 0;
                int hi = idx;
                while(lo <= hi) {
                    int mid = (lo + hi) / 2;

                    if (lis[mid] < arr[i]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                    
                }
                lis[lo] = arr[i];
            }
        }

        System.out.println(idx);
        
    }
}