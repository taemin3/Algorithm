import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int [] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] B = new int[m];
        for (int i = 0 ;i < m;i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        long [] sumA = make(A);
        long [] sumB = make(B);

        Arrays.sort(sumA);
        Arrays.sort(sumB);
        int l = 0;
        int r = sumB.length - 1;
       
        long ans = 0;
        while(l < sumA.length && r >= 0) {
            long a = sumA[l];
            long b = sumB[r];
            long s = sumA[l] + sumB[r];
            if (s == T) {
                int cntA = 0;
                int cntB = 0;
                while(l < sumA.length && sumA[l] == a) {
                    cntA++;
                    l++;
                }

                while(r >= 0  && sumB[r] == b) {
                    r--;
                    cntB++;
                }

                ans += (long) cntA * cntB;
            } else if (s > T) {
                r--;   
            } else {
                l++;
            }
            
        }

        System.out.println(ans);
        
    }

    public static long [] make(int [] k) {
        int n = k.length;
        int size = n*(n+1) / 2;
        long [] arr = new long[size];
        int idx = 0 ;
        for (int i = 0 ; i  < n;i++) {
            long sum = 0;
            for (int j = i; j < n;j++) {
                sum += k[j];
                arr[idx++] = sum;
            }
        }
        return arr;
    }
}