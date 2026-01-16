import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long [] A = new long[n];
        long [] B = new long[n];
        long [] C = new long[n];
        long [] D = new long[n];

        for (int i = 0; i < n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        long [] AB = new long[n * n];
        long [] CD = new long[n * n];

        int idx = 0;
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < n;j++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);
        
        long ans = 0;

        int l = 0;
        int r = n * n - 1;
        while(l < n * n && r >= 0) {
            long sum = AB[l] + CD[r];
            if (sum == 0) {
                long valA = AB[l];
                long valC = CD[r];
                int cntA = 0;
                int cntC = 0;
                while(l < n * n && AB[l] == valA) {
                    l++;
                    cntA++;
                }
                while(r >= 0 && CD[r] == valC) {
                    r--;
                    cntC++;
                }

                ans += (long) cntA * cntC;
            } else if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
        

        
        System.out.println(ans);
        
    }
}