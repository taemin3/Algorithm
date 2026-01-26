import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int n;
    static int [] in, post, idx;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        in = new int[n + 1];
        post = new int[n + 1];
        idx = new int[n + 1];

        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n;i++) {
            in[i] = Integer.parseInt(st.nextToken());
            idx[in[i]] = i; 
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n;i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }
        solve(1,n,1,n);
        System.out.println(sb.toString());
        
    }

    static void solve(int inL, int inR, int postL,int postR) {
        if (inR < inL || postR < postL) return;
        int root = post[postR];
        sb.append(root + " ");

        int rootIdx = idx[root];
        int left = rootIdx - inL;

        solve(inL,rootIdx - 1,postL,postL + left - 1);
        solve(rootIdx + 1,inR,postL + left,postR - 1);
    }
}