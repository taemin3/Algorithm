import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long [] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long ans = Long.MAX_VALUE;

        Arrays.sort(arr);
        long [] array = new long[3];
        
        for (int i = 0; i < N ; i++) {
            
    

            int l = i + 1;
            int r = N - 1;
            while(l < r) {
                long sum = arr[i];
                sum += arr[l] + arr[r];
                
                long abs = Math.abs(sum);
                
                if (abs < ans) {
                    ans = abs;
                    array[0] = arr[i];
                    array[1] = arr[l];
                    array[2] = arr[r];
                }

                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    break;
                }
            }
        }
        Arrays.sort(array);
        for (int i = 0 ; i < 3; i++ ) {
            System.out.print(array[i] + " ");
        }
    }
}