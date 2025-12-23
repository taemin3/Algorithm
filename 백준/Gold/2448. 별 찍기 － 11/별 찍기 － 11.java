import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static char [][] board;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n*2 - 1];
        for (int i = 0; i < n;i++) {
            Arrays.fill(board[i],' ');
        }
        draw(n,0, n - 1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n;i++) {
            sb.append(board[i]).append('\n');
        }
        System.out.println(sb);
        
    }

    public static void draw(int h,int x,int y) {
        if (h == 3) {
            board[x][y] = '*';
            board[x + 1][y - 1] = '*';
            board[x + 1][y + 1] = '*';
            for (int i = y - 2; i <= y + 2;i++) {
                board[x+2][i] = '*';
            }
            return;
        }
        int half = h / 2;
        draw(half, x,y);
        draw(half,x + half, y - half);
        draw(half,x + half, y + half);
    }
}