import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int [] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i],max);
        }

        int [] pos = new int[max + 1];
        Arrays.fill(pos,-1);
        for (int i = 0; i < N;i++) {
            pos[arr[i]] = i;
        }

        for (int i = 0; i < N;i++) {
            int x = arr[i];
            for (int j = x + x; j <= max ; j += x) {
                if (pos[j] != -1) {
                    ans[pos[j]]--;
                    ans[i]++;
                }
            }
        }

        for (int i = 0 ; i < N;i++) {
            System.out.print(ans[i] + " ");
        }
        
        
    }

    

    
}