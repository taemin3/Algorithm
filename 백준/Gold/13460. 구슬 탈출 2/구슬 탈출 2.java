import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N, M;
    static char [][] map;
    static int hx, hy;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];

        for (int i = 0 ; i < N;i++) {
            String str = br.readLine();
            for (int j = 0 ; j < M;j++) {
                map[i][j] = str.charAt(j); 
                if (map[i][j] == 'O') {
                    hx = i;
                    hy = j;
                }
            }
        }
        System.out.println(bfs());
        
    }

    static int bfs() {
        boolean[][][][] visit = new boolean[N][M][N][M];
        Queue<int[]> q = new LinkedList<>();
        int [] r = new int[2];
        int [] b = new int[2];

        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        
        for (int i = 0;i < N;i++){
            for (int j = 0 ; j < M;j++) {
                if(map[i][j] == 'R') {
                    r[0] = i;
                    r[1] = j;
                }
                if(map[i][j] == 'B') {
                    b[0] = i;
                    b[1] = j;
                }
            }
        }
        visit[r[0]][r[1]][b[0]][b[1]] = true;
        q.offer(new int[]{r[0],r[1],b[0],b[1],0});
        
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int rx = cur[0];
            int ry = cur[1];
            int bx = cur[2];
            int by = cur[3];
            int cnt = cur[4];
            if (cnt >= 10) return -1;
            

            for (int i = 0 ; i < 4;i++) {
                int nrx = rx;
                int nry = ry;
                int nbx = bx;
                int nby = by;

                boolean redHole = false;
                boolean blueHole = false;

                int distR = 0;
                int distB = 0;


                while(map[nrx + dx[i]][nry + dy[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];
                    distR++;
                    if (map[nrx][nry] == 'O') {
                        redHole = true;
                        break;
                    }
                }

                while(map[nbx + dx[i]][nby + dy[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];
                    distB++;
                    if (map[nbx][nby] == 'O') {
                        blueHole = true;
                        break;
                    }
                }
                if (blueHole) continue;

                if (redHole) return cnt + 1;

                if (nrx == nbx && nry == nby) {
                    if (distR < distB) {
                        nbx -= dx[i];
                        nby -= dy[i];
                    } else{
                        nrx -= dx[i];
                        nry -= dy[i];
                    }
                }

                if (visit[nrx][nry][nbx][nby]) continue;
                visit[nrx][nry][nbx][nby] = true;
                q.offer(new int[]{nrx,nry,nbx,nby, cnt + 1});
                
            }

            
        }
        return -1;
    }

    
    

    
   
}