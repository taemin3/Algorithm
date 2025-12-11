import java.util.*;
class Solution {
    
    static int[] parent;
    static String[] value;
    
    public String[] solution(String[] commands) {
        
        
        List<String> list = new ArrayList<>();
        
        parent = new int[2501];
        value = new String[2501];
        
        for (int i = 1; i < 2501;i++) {
            parent[i] = i;
           
        }
        
        for (String co : commands) {
            String[] str = co.split(" ");
            if (str[0].equals("UPDATE")) {
                if (str.length == 4) {
                    int r = Integer.parseInt(str[1]);
                    int c = Integer.parseInt(str[2]);
                    int idx = idx(r,c);
                    int root = find(idx);
                    value[root] = str[3];
                } else {
                    String v1 = str[1];
                    String v2 = str[2];
                    
                    for (int i = 1; i <= 2500;i++) {
                        
                        if (parent[i] == i && v1.equals(value[i])) {
                            value[i] = v2;
                        }
                    }
                }
            } else if (str[0].equals("MERGE")) {
                int r1 = Integer.parseInt(str[1]);
                int c1 = Integer.parseInt(str[2]);
                int r2 = Integer.parseInt(str[3]);
                int c2 = Integer.parseInt(str[4]);
                
                int idx1 = idx(r1,c1);
                int idx2 = idx(r2,c2);
                
                merge(idx1,idx2);
            } else if (str[0].equals("UNMERGE")) {
                int r1 = Integer.parseInt(str[1]);
                int c1 = Integer.parseInt(str[2]);
                int idx = idx(r1,c1);
                unmerge(idx);
            } else {
                int r1 = Integer.parseInt(str[1]);
                int c1 = Integer.parseInt(str[2]);
                int idx = idx(r1,c1);
                int root = find(idx);
                if (value[root] == null) {
                    list.add("EMPTY");
                } else {
                    list.add(value[root]);
                }
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0;i < list.size();i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
    
    public int idx(int r,int c) {
        return (r-1) * 50 + c;
    }
    
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void merge(int idx1, int idx2) {
        int root1 = find(idx1);
        int root2 = find(idx2);
        if (root1 == root2) return;
        String newVal;
        if (value[root1] != null) {
            newVal = value[root1];
        } else if(value[root2] != null) {
            newVal = value[root2];
        } else {
            newVal = null;
        }
        parent[root2] = root1;
        value[root1] = newVal;
        
        value[root2] = null;
        
    }
    
    public void unmerge(int idx) {
        int root = find(idx);
        String val = value[root];
        
        List<Integer> group = new ArrayList<>();
        for (int i = 1; i <= 2500;i++) {
            if(find(i) == root) {
                group.add(i);
            }
        }
        
        for (int g : group) {
            parent[g] = g;
            value[g] = null;
        }
        value[idx] = val;
    }
}