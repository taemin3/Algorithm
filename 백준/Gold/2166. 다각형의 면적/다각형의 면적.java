import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long [] x = new long[n];
        long [] y = new long[n];

        for (int i = 0; i < n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());

            
        }
        long sum1 = 0;
       
        for (int i = 0; i < n;i++) {
            if (i == n-1) {
                sum1 += x[i]  * y[0] - y[i] * x[0];
            } else {
                sum1 += x[i] * y[i+1] - y[i] * x[i+1];
            }
        }
  
        double anw = Math.abs(sum1) / 2.0;
        System.out.printf("%.1f",anw);
        
    }
}