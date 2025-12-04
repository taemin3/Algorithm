import java.util.*;
class Solution {
    public String[] solution(String[] files) {
     
        int n = files.length;
        List<String []> list = new ArrayList<>();
        
        for (int i = 0 ; i < n;i++) {
            String file = files[i];
            int len = file.length();
            int idx = 0;
            
            StringBuilder head = new StringBuilder();
            while(idx < len && !Character.isDigit(file.charAt(idx))) {
                head.append(file.charAt(idx));
                idx++;
            }
            
            StringBuilder number = new StringBuilder();
            while(idx < len && Character.isDigit(file.charAt(idx)) && number.length() < 5) {
                number.append(file.charAt(idx));
                idx++;
            }
            
            String headstr = head.toString();
            String numstr = number.toString();
            list.add(new String[] {
                file,
                headstr.toLowerCase(),
                numstr,
                String.valueOf(i)
            });
        }
        Collections.sort(list, (a,b) -> {
            int headCmp = a[1].compareTo(b[1]);
            if (headCmp != 0) return headCmp;
            
            int numA = Integer.parseInt(a[2]);
            int numB = Integer.parseInt(b[2]);
            if(numA != numB ) return numA - numB;
            
            int idxA = Integer.parseInt(a[3]);
            int idxB = Integer.parseInt(b[3]);
            return idxA - idxB;
        });
        
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = list.get(i)[0];
        }
            
        
        
        
        return answer;
    }
}