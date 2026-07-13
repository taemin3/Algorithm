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
        int max = -1;

        for (int i = 0 ; i < N;i++) {
            for (int j = i + 1;j < N;j++) {
                for (int k = j + 1;k < N;k++) {
                    
                    if (arr[i] % 10 + arr[j] % 10 + arr[k] % 10 >= 10) {
                        continue;
                    }
                    if (arr[i] % 100 / 10 + arr[j]  % 100 / 10 + arr[k]  % 100 / 10 >= 10) {
                        continue;
                    }
                    if (arr[i] % 1000 / 100 + arr[j]  % 1000 / 100 + arr[k]  % 1000 / 100 >= 10) {
                        continue;
                    }
                    if (arr[i] % 10000 / 1000 + arr[j]  % 10000 / 1000 + arr[k]  % 10000 / 1000 >= 10) {
                        continue;
                    }
                    max = Math.max(max,arr[i] + arr[j]+arr[k]);
                }
            }
        }
       
        System.out.println(max);
    }
}