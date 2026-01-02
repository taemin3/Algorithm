import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n ;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int r = n - 1;
        int l = 0;
        int [] anw = new int[2];
        long k = Long.MAX_VALUE;
        while(l < r) {
            long num = arr[l] + arr[r];
            if (num < 0) {
                if (num * -1 < k) {
                    anw[0] = arr[l];
                    anw[1] = arr[r];
                    k = num * -1;
                }
                l++;
            } else if (num > 0) {
                if (num < k) {
                    anw[0] = arr[l];
                    anw[1] = arr[r];
                    k = num;
                }
                r--;
            } else {
                anw[0] = arr[l];
                anw[1] = arr[r];
                break;
            }
        }
        System.out.print(anw[0] + " " + anw[1]);
    }
}