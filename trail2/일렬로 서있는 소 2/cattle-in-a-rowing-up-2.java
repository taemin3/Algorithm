import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0 ; i < N;i++ ){
            A[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0 ; i < N;i++) {
            for (int j = i + 1; j < N;j++) {
                if (A[j] >= A[i]) {
                    for (int k = j + 1;k < N;k++) {
                        if (A[k] >= A[j]) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}