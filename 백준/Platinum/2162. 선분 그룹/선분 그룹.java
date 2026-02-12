import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int [] parent;
    static int [] size;

    static class Point{
        long x, y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean union(int a,int b) {
        int ra = find(a);
        int rb = find(b);
        
        if (ra == rb) return false;
        if (size[ra] > size[rb]) {
            size[ra] += size[rb];
            size[rb] = size[ra];
            parent[rb] = ra;
        } else if (size[rb] > size[ra]) {
            size[rb] += size[ra];
            size[ra] = size[rb];
            parent[ra] = rb;
        } else {
            size[ra] += size[rb];
            size[rb] = size[ra];
            parent[rb] = ra;
        }
        return true;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point [] p = new Point[n * 2];

        parent = new int[n];
        size = new int[n];

        for (int i = 0 ; i < n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        for (int i = 0 ; i < n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            p[i*2] = new Point(x1,y1);
            p[i*2 + 1] = new Point(x2,y2);
            
        }

        for (int i = 0 ; i < n - 1; i++) {
            for (int j = i + 1; j < n;j++) {
                Point a = p[i*2];
                Point b = p[i*2+1];
                Point c = p[j*2];
                Point d = p[j*2+1];
    
                int res1 = ccw(a,b,c) * ccw(a,b,d);
                int res2 = ccw(c,d,a) * ccw(c,d,b);
    
                if (res1 == 0 && res2 == 0) {
                    if (Math.min(a.x,b.x) <= Math.max(c.x,d.x) &&
                        Math.min(c.x,d.x) <= Math.max(a.x,b.x) && 
                        Math.min(a.y,b.y) <= Math.max(c.y,d.y) &&
                        Math.min(c.y,d.y) <= Math.max(a.y,b.y) 
                       ) {
                            union(i,j);
                       }
                } else if (res1 <= 0 && res2 <= 0) {
                    union(i,j);
                } 

                
                
            }
            
            
        }
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0;i < n;i++) {
            set.add(find(i));
            max = Math.max(size[i],max);
        }

        System.out.println(set.size());
        System.out.println(max);

        
        
        
    }

    static int ccw(Point a, Point b, Point c) {
        long result = (a.x*b.y + b.x*c.y + c.x*a.y) - (a.x*c.y + b.x*a.y + c.x*b.y);
        if (result > 0) return 1;
        else if (result == 0) return 0;
        return -1;
    }

    
}