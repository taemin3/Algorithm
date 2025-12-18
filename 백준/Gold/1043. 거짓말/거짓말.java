import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean [] value;
    static int [] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        value = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n;i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        List<Integer> truth = new ArrayList<>();
        for (int i = 0; i < k;i++) {
            int num = Integer.parseInt(st.nextToken());
            value[num] = true;
            truth.add(num);
        }

        int [][] party =new int[m][];
        for (int i = 0; i < m;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            party[i] = new int[s];
            boolean flag = false;
            for (int j = 0; j < s;j++){
                int num = Integer.parseInt(st.nextToken());
                
                party[i][j] = num;
            }
            for (int j = 1; j < s; j++) {
                union(party[i][0], party[i][j]);
            }
        }
        for (int t: truth) {
            value[find(t)] = true;
        }
        int answer = 0;
        for (int i = 0;i < m;i++){
            boolean flag = true;
            for (int p : party[i]) {
                if(value[find(p)]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }
        System.out.println(answer);
        
        
    }

    public static void union(int a,int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    } 

    public static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
        
    }
}