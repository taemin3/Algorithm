import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {


    static class Point{
        long x, y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

        Point [] p = new Point[4];

        for (int i = 0 ; i < 2;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            p[i*2] = new Point(x1,y1);
            p[i*2 + 1] = new Point(x2,y2);
        }

        for (int i = 0 ; i < 1; i++) {
            for (int j = i + 1; j < 2;j++) {
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
                            System.out.println(1);
                       }
                    else {
                        System.out.println(0);
                    }
                } else if (res1 <= 0 && res2 <= 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }

                
                
            }
            
            
        }
   
        
        
        
    }

    static int ccw(Point a, Point b, Point c) {
        long result = (a.x*b.y + b.x*c.y + c.x*a.y) - (a.x*c.y + b.x*a.y + c.x*b.y);
        if (result > 0) return 1;
        else if (result == 0) return 0;
        return -1;
    }

    
}