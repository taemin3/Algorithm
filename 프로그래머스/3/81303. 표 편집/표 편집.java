import java.util.*;
class Solution {
    
    
    
    public String solution(int n, int k, String[] cmd) {
        int [] prev = new int[n];
        int [] next = new int[n];
        boolean [] deleted = new boolean[n];
        for (int i = 0 ; i < n;i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        int idx = k;
        Stack<Integer> stack = new Stack<>();
        
        for (String c : cmd) {
            String [] str = c.split(" ");
            switch(str[0]) {
                case "D":{
                    int x = Integer.parseInt(str[1]);
                    
                    for (int i = 0; i < x; i++) {
                        idx = next[idx];
                    }
                    
                    break;}
                case "U":{
                    int x = Integer.parseInt(str[1]);
                    for (int i = 0; i < x; i++) {
                        idx = prev[idx];
                    }
                    break;}
                case "C":{
                    stack.push(idx);
                    deleted[idx]  = true;
                    
                    int p = prev[idx];
                    int nxt = next[idx];
                    
                    if (p != -1) next[p] = nxt;
                    if (nxt != -1) prev[nxt] = p;
                    
                    idx = (nxt != -1) ? nxt : p;
                    
                    break;}
                case "Z":{
                    int a = stack.pop();
                    deleted[a] =false;
                    int p = prev[a];
                    int nxt = next[a];
                    
                    if (p != -1) next[p] = a;
                    if (nxt != -1) prev[nxt] = a;
                    
                    break;
                }
            } 
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0 ; i < deleted.length;i++){
            if(deleted[i]) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }
        return sb.toString();
    }
}