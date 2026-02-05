import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static List<Integer>[] list;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for (int i = 1;i <= n;i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2;i <= n;i++) {
            int a = Integer.parseInt(st.nextToken());
            list[a].add(i);
        }
        arr = new int[n + 1];

        for (int i = 0;i < m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] += b;
        }
        dfs(1);
        
        for (int i = 1 ; i <= n;i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
    static void dfs(int x) {
        for (int l : list[x]) {
            arr[l] += arr[x];
            dfs(l);
        }
    }
}