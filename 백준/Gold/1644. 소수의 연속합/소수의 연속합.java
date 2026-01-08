import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean [] check = new boolean[N+1];
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i * i <= N;i++) {
            if (!check[i]) {
                for (int j = i * i; j <= N;j += i) {
                    check[j] = true;
                }
            }
        }
        for (int i = 2; i <= N;i++) {
            if(!check[i]) prime.add(i);
        }

        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while(true) {
            
            if (sum >= N) {
                if (sum == N) count++;
                sum -= prime.get(l++);
            } else {
                if (r == prime.size()) break;
                sum += prime.get(r++);
            }
            
        }
        System.out.println(count);
        
            
        
    }
}