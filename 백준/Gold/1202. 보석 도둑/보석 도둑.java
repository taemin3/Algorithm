import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [][] arr = new int[N][2];
        int [] bag = new int[K];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for (int i = 0; i < N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        for (int i = 0; i < K;i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        long ans = 0;
        int idx = 0;
        for (int i = 0; i < K;i++) {
            
            while (idx < N) {
                if (arr[idx][0] <= bag[i]) {
                    pq.offer(arr[idx][1]);
                    idx++;
                } else {
                    break;
                }
            }
            if (!pq.isEmpty()) {
                 ans += pq.poll();
            }
           
        }
        

        
        

        
        
        
        System.out.println(ans);
    }
    

    
}