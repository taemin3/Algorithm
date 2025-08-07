class Solution {
    public int[] solution(String s) {
        
        int count = 0;
        int count2 = 0;
        while(!s.equals("1")) {
            for (int i = 0; i < s.length();i++) {
                if (s.charAt(i) == '0') {
                    count++;
                } 
            }
            s = s.replace("0","");
            int a = s.length();
            s = Integer.toBinaryString(a);
            count2++;
        }
        int[] answer = {count2,count};
        
            
            
        
        
        
        return answer;
    }
}