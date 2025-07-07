import java.util.*;
import java.io.*;
public class Main {
    static int [] num;
    static int [] array3;
    static int [][] array;
    static int [][][] array2;
    static boolean [] visit;
    static boolean [][] visit2;
    static boolean [][] visit3;
    static int n,m,h;
    static char [][] charArray;
    static char [][] charArray2;
    static int count;
    static Map<Integer,Integer> map;
    static Queue<Integer> que;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> [] list;
    static long a,b;
    static ArrayList<Node1> chickenList = new ArrayList<>();
    static ArrayList<Node1> homeList = new ArrayList<>();

    public static class Node1 {
        int x;
        int y;
        public Node1(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n][n];

        for (int i = 0; i < n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n;j++) {
                int a = Integer.parseInt(st.nextToken());
                array[i][j] = a;
                if (a == 1) {
                    homeList.add(new Node1(i,j));
                } else if (a == 2) {
                    chickenList.add(new Node1(i,j));
                }

            }
        }

        visit = new boolean[chickenList.size()];
        backtracking(0,0);
        System.out.println(min);

    }

    public static void backtracking(int count, int idx) {
        if (count == m) {
            int total = 0;
            for (int i = 0; i < homeList.size();i++) {
                int a = Integer.MAX_VALUE;
                for (int j = 0; j < chickenList.size();j++) {
                    if (visit[j] == true) {
                        int dist = Math.abs(chickenList.get(j).x - homeList.get(i).x) +
                                Math.abs(chickenList.get(j).y - homeList.get(i).y);
                        a = Math.min(dist,a);
                    }

                }
                total += a;
            }
            min = Math.min(total,min);
            return;
        }

        for (int i = idx; i < chickenList.size();i++) {
            if (!visit[i]) {
                visit[i]  = true;
                backtracking(count + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}