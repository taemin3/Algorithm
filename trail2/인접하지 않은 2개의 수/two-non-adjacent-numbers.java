import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0 ; i < N - 2;i++) {
            for (int j = i + 2; j < N;j++) {
                int val = arr[i] + arr[j];
                if (val > max) max = val;
            }
        }
        System.out.println(max);
    }
}