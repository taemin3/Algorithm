import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0 ; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int anw = Integer.MAX_VALUE;

        for (int i = 0; i < N;i++) {
            for (int j = i + 1;j < N;j++) {
                int num = sum - (arr[i]+arr[j]);
                anw = Math.min(anw, Math.abs(S - num));
            }
        }
        System.out.println(anw);
    }
}