import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static boolean [][] visit;
    static char [][] map;
    static boolean [] key;
    static List<int[]>[] door;
    static int h, w;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test = 0;test < t;test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            h = H + 2;
            w = W + 2;
            map = new char[h][w];
            for (int i = 0; i < h;i++) {
                Arrays.fill(map[i],'.');
            }
            visit = new boolean[h][w];
            
            for (int i = 1;i < h - 1;i++) {
                String str = br.readLine();
                for (int j = 1; j < w - 1;j++) {
                    map[i][j] = str.charAt(j - 1);
                }
            }
            key = new boolean[26];
            door = new ArrayList[26];
            
            for (int i =0;i<26;i++) {
                door[i] = new ArrayList<>();
            }
            
            String str = br.readLine();
            if (!str.equals("0")) {
                for (int i = 0;i < str.length();i++) {
                    char c = str.charAt(i);
                    key[c - 'a'] = true;
                }
            }
            sb.append(bfs() + "\n");
            
        }
        System.out.println(sb);
    }

    static int bfs() {
        ans = 0;
        Queue<int[]> q = new LinkedList<>();
        visit[0][0] = true;
        q.offer(new int[]{0,0});
        
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0 ; i < 4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] == '*') continue;
                char c = map[nx][ny];
                if (c >= 'A' && c <= 'Z') {
                    if (!key[c - 'A']) {
                        door[c - 'A'].add(new int[]{nx,ny});
                        visit[nx][ny] = true;
                    } else{
                        visit[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                    
                } else if (c >= 'a' && c <= 'z') {
                    
                    visit[nx][ny] = true;
                    if (!key[c - 'a']) {
                        key[c - 'a'] = true;
                        for (int[] d : door[c - 'a']) {
                            q.offer(new int[]{d[0],d[1]});
                        }
                        door[c - 'a'].clear();
                    }
                    
                    
                    q.offer(new int[]{nx,ny});
                } else if (c == '$') {
                    ans++;
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                } else {
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
                
            }
        }
        return ans;
    }
}