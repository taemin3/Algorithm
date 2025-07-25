import java.util.*;
import java.io.*;
public class Main {
   

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] array = new int[m];
        int [] array2 = new int[m];
        for (int i = 0; i < m;i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = Integer.parseInt(st.nextToken());
            array2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        Arrays.sort(array2);
        int sum = 0;

        while(n >= 0) {

            int a = array[0];
            int b;
            if (n < 6) {
                b = array2[0] * n;
            } else {
                b = array2[0] * 6;
            }
            if (a < b) {
                sum += a;
            } else {
                sum += b;
            }

            n -= 6;
        }

        System.out.println(sum);


    }}