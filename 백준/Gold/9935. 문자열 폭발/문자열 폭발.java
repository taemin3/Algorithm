import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();
        int len = boom.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length();i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= len) {
                boolean same = true;
                for (int j = 0;j < len;j++) {
                    if (sb.charAt(sb.length() - len + j) != boom.charAt(j)) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                sb.delete(sb.length() - len,sb.length());
            } 
            }
            
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
        
    }

 
   
}