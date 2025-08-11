class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        
        while(Math.abs(a - b) != 0) {
              
            
            answer++;
            a = (int) Math.ceil((double) a / 2);
            b = (int) Math.ceil((double) b / 2);
            
        }
        
        
        
        

        return answer;
    }
}