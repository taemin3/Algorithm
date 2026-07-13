import java.util.*;
import java.io.*;

public class Main {


    static int N, M;

    public static boolean inRange(int x,int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        char [][] map = new char[N][M];

        for (int i = 0 ; i < N;i++) {
            String str = br.readLine();
            for (int j = 0 ; j < M;j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int [] dx = {0,1,1,1,0,-1,-1,-1};
        int [] dy = {1,1,0,-1,-1,-1,0,1};

        int anw = 0;

        for (int i = 0 ; i < N;i++) {
            for (int j = 0;j < M;j++) {
                if (map[i][j] == 'L') {
                    for (int k = 0; k < 8;k++) {
                    int cx = i;
                    int cy = j;
                    int cnt = 0;
                    while(true) {
                        int nx = cx + dx[k];
                        int ny = cy + dy[k];
                        if (!inRange(nx,ny)) break;

                        if (cnt == 0 && map[nx][ny] == 'E') {
                            cnt++;
                            cx = nx;
                            cy = ny;
                            continue;
                        } else if (cnt == 1 && map[nx][ny] == 'E') {
                            anw++;
                            break;
                        } 
                        break;
                    }
                    

                    
                }
                }
                
                
            }
        }
        System.out.println(anw);
        
    }
}