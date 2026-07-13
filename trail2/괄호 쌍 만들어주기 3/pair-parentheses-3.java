import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;

        for (int i = 0 ; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                for (int j = i + 1; j < str.length();j++) {
                    char d = str.charAt(j);
                    if (d == ')') count++;
                }
            }
        }
        System.out.println(count);
    }
}