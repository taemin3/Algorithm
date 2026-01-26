import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Shark{
        int r,c,s,d,z;
        public Shark(int r,int c,int s,int d,int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int R, C, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        Map<Integer,Shark> list = new HashMap<>();
        
        for (int i = 0 ; i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r,c,s,d,z);
            list.put(i+1,shark);
            map[r][c] = i+1;
        }

        int ans = 0;
        int idx = -1;
        for (int j = 0 ; j < C;j++) {
            idx++;
            for (int i = 0; i < R;i++) {
                if (map[i][j] != 0) {
                    int id = map[i][j];
                    ans += list.get(id).z;
                    map[i][j] = 0;
                    list.remove(id);
                    break;
                }
            }

            for (int key : list.keySet()) {
                Shark shark = list.get(key);
                map[shark.r][shark.c] = 0;

                if (shark.d == 1) {
                    if(move(shark, -1,shark.d) == 1) shark.d = 2;
                } else if (shark.d == 2) {
                    if(move(shark, 1,shark.d) == -1) shark.d = 1;
                } else if (shark.d == 3) {
                    if(move(shark, 1,shark.d) == -1) shark.d = 4;
                } else if (shark.d == 4) {
                    if(move(shark, -1,shark.d) == 1) shark.d = 3;
                }
                
            }
            List<Integer> remove = new ArrayList<>();

            for (int key : list.keySet()) {
                Shark shark = list.get(key);
                if (map[shark.r][shark.c] > 0) {
                    if (list.get(map[shark.r][shark.c]).z > shark.z) {
                        remove.add(key);
                    } else {
                        remove.add(map[shark.r][shark.c]);
                        map[shark.r][shark.c] = key;
                    }
                } else {
                    map[shark.r][shark.c] = key;
                }
            }

            for (int key : remove) {
                list.remove(key);
            }
        }
        System.out.println(ans);
        
    }

    static int move(Shark shark, int d, int type) {
        int cnt = shark.s;
        while(cnt > 0) {
            if (type == 1 || type == 2) {
                if (shark.r == 0) d = 1;
                else if (shark.r == R - 1) d = -1;
                shark.r += d;
            } else {
                if (shark.c == 0) d = 1;
                else if (shark.c == C - 1) d = -1;
                shark.c += d;
            }
            cnt--;
        }
        return d;
        
    }

    
    
    

    
   
}