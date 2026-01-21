import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M;
    static int [][] map;
    static boolean [][] visit;
    static int [][] group;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        group = new int[N][M];
        int [][] ans = new int[N][M];
        int [] groupSize = new int[N*M + 1];

        for (int i = 0; i < N;i++) {
            String str = br.readLine();
            for (int j = 0; j < M;j++) {
                int a = str.charAt(j) - '0';
                map[i][j] = a;
            }
        }
        int idx = 1;
        for (int i = 0; i < N;i++) {
            for (int j = 0; j < M;j++) {
                if (map[i][j] == 0 && group[i][j] == 0) {
                    groupSize[idx] = bfs(i,j,idx);
                    idx++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        

        for (int i = 0; i < N;i++) {
            for (int j = 0; j < M;j++) {
                if (map[i][j] == 0) {
                    sb.append(0);
                } else {
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0 ; k <4;k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if (group[nx][ny] == 0) continue;
                        set.add(group[nx][ny]);
                    }
                    int sum = 1;
                    for (int s : set) {
                        sum += groupSize[s];
                    }
                    sb.append(sum % 10);
                }
            }
            sb.append("\n");
            
        }
        System.out.print(sb.toString());

    }

    public static int bfs(int x, int y,int id) {
        group[x][y] = id;
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{x,y});
        int count = 1;
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            for (int i = 0; i < 4;i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (group[nx][ny] != 0) continue;
                if (map[nx][ny] == 1) continue;
                group[nx][ny] = id;
                q.offer(new int[]{nx,ny});
                count++;
            }
        }
        
        return count;
    }
}