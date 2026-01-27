import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Node{
        Map<String,Node> child = new HashMap<>();
    }
    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Node cur = root;
            for (int j = 0; j < K;j++) {
                String str = st.nextToken();
                if(!cur.child.containsKey(str)) {
                    cur.child.put(str,new Node());
                }
                cur = cur.child.get(str);
            }
        }
        dfs(root,0);
        System.out.println(sb);
        
    }
    static void dfs(Node node,int depth) {
        List<String> key = new ArrayList<>(node.child.keySet());
        Collections.sort(key);

        for (String k : key) {
            int cnt = depth * 2;
            for (int i = 0 ; i < cnt;i++) {
                sb.append("-");
            }
            sb.append(k);
            sb.append("\n");
            dfs(node.child.get(k),depth + 1);
        }
    }

    
}