import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        

        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while(stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); 
            } else {
                while(!stack.isEmpty() && pri(stack.peek()) >= pri(c)) {
                    if (stack.peek() == '(') break;
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
           
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
        
        
    }

    public static int pri(char ch) {
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return 0;
    }

}