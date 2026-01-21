import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int [] parent;

    static int find(int x)  {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i = 1 ; i <= G;i++) {
            parent[i] = i;
        }
        int ans = 0;
        for (int i = 0; i < P;i++) {
            int a = Integer.parseInt(br.readLine());

            int b = find(a);
            if (b == 0) {
                break;
            }
            ans++;
            parent[b] = find(b-1); 

            
        }
        System.out.println(ans);
        
    }
}