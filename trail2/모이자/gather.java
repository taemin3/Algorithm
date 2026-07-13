import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0 ; i < N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N;i++) {
            int sum = 0;
            for (int j = 0 ; j < N;j++) {
                sum += (Math.abs(j - i)) * A[j];
            }
            if (sum < min) min = sum;
        }
        System.out.println(min);
    }
}