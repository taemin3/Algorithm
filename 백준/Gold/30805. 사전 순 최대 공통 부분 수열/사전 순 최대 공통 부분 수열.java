import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n;i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        int [] b = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m ; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(true) {
            int pickV = -1;

            for (int v = 100; v > 0; v--) {
                int p = find(a,i,v);
                if (p == -1) continue;

                int q = find(b,j,v);
                if (q == -1) continue;

                pickV = v;
                i = p + 1;
                j = q + 1;
                break;
            }
            if (pickV == -1) break;
            ans.add(pickV);
            
        }
        
        System.out.println(ans.size());
        for (int k = 0; k < ans.size();k++) {
            System.out.print(ans.get(k) + " ");
        }
    }

    public static int find(int [] arr,int start, int val) {
        for (int i = start; i < arr.length;i++){
            if (arr[i] == val) return i;
        }
        return -1;
    }
}