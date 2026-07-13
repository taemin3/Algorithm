import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for (int i = 0 ; i < N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        } 
        int min = Integer.MAX_VALUE;

        for (int i = 0 ; i < N;i++) {
            int sum = 0;
            for (int j = i; j < N + i ; j++) {
                if (j >= N) {
                    sum += arr[j - N] * (j - i);
                } else {
                    sum += arr[j] * (j - i);
                }
                
            }
            if (sum < min) min = sum; 
        } 
        System.out.println(min);
    }
}