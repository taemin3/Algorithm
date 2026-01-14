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
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> [] list;
    static long a,b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int [][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 1;i <= str1.length();i++) {
            for(int j = 1; j <= str2.length() ; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
    }}