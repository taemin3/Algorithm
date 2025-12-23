import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] left = new int[n];
        int [] right = new int[n];
        int [] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0 ; i < n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n;i++) {
            left[i] = 1;
            for (int j = 0; j < i;j++) {
                if (arr[j] < arr[i]) {
                    left[i] = Math.max(left[i],left[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0;i--) {
            right[i] = 1;
            for (int j = n - 1;j > i;j--) {
                if (arr[j] < arr[i]){
                    right[i] = Math.max(right[i],right[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0 ; i < n;i++) {
            ans = Math.max(ans,left[i] + right[i] - 1);
        }

        System.out.println(ans);
        
    }

   
}