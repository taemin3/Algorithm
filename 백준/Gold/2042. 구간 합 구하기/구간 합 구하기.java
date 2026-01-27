import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static long [] tree;
    static long [] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        tree = new long[N * 4];
        arr = new long[N + 1];
        for (int i = 1;i <= N;i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        build(1,1,N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < M + K;i++) {
             st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            long v2 = Long.parseLong(st.nextToken());
            if (t == 1) {
                update(1,1,N,v1,v2);
            } else {
                sb.append(sum(1,1,N,v1,(int) v2) + "\n");
            }
        }
        System.out.println(sb);
    }

    static long build(int node,int start,int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = build(node*2,start,mid) + build(node*2 + 1,mid +1,end);
    }

    static void update(int node, int start,int end, int idx, long val) {
        if (idx < start || idx > end) {
            return;
        } 
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        update(node*2,start,mid,idx,val);
        update(node*2 + 1, mid +1,end,idx,val);
        tree[node] = tree[node*2] + tree[node*2 + 1];
        
    }

    static long sum(int node,int start,int end, int l,int r) {
        if (r < start || l > end) return 0;
        if (l <= start && r >= end) return tree[node];
        int mid = (start + end) / 2;
        return sum(node*2,start,mid,l,r) + sum(node*2 + 1,mid+1,end,l,r);
    }
}