class Solution {
    public int solution(int n) {
        int answer = 0;
        String nStr = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < nStr.length();i++) {
            if(nStr.charAt(i) == '1'){
                count++;
            }
        }
        while(true) {
            n++;
            int count2 = 0;;
           
            String str = Integer.toBinaryString(n);
            
            for (int i = 0; i < str.length();i++) {
                if(str.charAt(i) == '1') {
                    count2++;
                }
            }
            if (count == count2) { 
                    answer = n;
                    break;
            } else if (n == 1000001) {
                break;
            }
        }
        
        return answer;
    }
}