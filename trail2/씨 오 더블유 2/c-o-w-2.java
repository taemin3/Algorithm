import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int count = 0 ;
        for (int i = 0 ; i < str.length() - 2;i++) {
            if (str.charAt(i) == 'C') {
                for (int j = i +1;j < str.length() - 1;j++) {
                    if (str.charAt(j) == 'O') {
                        for (int k = j +1;k < str.length();k++) {
                            if (str.charAt(k) == 'W') {
                                count++;
                            }
                        }
                    }
                }
            }
            
        }
        System.out.println(count);
    }
}