class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0 ; i < numbers.length;i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String str = Long.toBinaryString(numbers[i]);
                str = "0"+str;
                int idx = str.lastIndexOf("0");
                
                String anw = str.substring(0,idx) + "10" + 
                    str.substring(idx + 2);
                answer[i] = Long.parseLong(anw,2);
            }
        }
        
        return answer;
    }
}