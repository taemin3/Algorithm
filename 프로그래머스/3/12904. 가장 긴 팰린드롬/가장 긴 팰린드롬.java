class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        
        for (int i = 0; i < n;i++) {
            answer = Math.max(answer, sol(s,i,i));
            if (i < n - 1) {
                answer = Math.max(answer, sol(s,i,i+1));
            }
        }

    
        
        return answer;
    }
    
    public int sol(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}