import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][2];
        for (int i = 0 ; i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0 ; i < N - 1;i++) {
            sum += Math.abs(arr[i][0] - arr[i+1][0]) + Math.abs(arr[i][1] - arr[i + 1][1]); 
        }
        int min = Integer.MAX_VALUE;
        
        for (int i = 1 ; i < N - 1;i++) {
            int nsum = sum;
            nsum -= Math.abs(arr[i][0] - arr[i-1][0]) + Math.abs(arr[i][1] - arr[i - 1][1])
            +Math.abs(arr[i][0] - arr[i+1][0]) + Math.abs(arr[i][1] - arr[i + 1][1]); 
            nsum += Math.abs(arr[i - 1][0] - arr[i+1][0]) + Math.abs(arr[i - 1][1] - arr[i + 1][1]);
            if (nsum < min) min = nsum;
        }
        System.out.println(min);
    }
}