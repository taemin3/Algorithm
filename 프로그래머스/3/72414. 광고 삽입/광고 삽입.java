class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int pt = toSec(play_time);
        int at = toSec(adv_time);
        
        if (pt == at) return "00:00:00";
        
        long[] view = new long[pt + 1];
        
        for (String l : logs) {
            String [] str = l.split("-");
            int start = toSec(str[0]);
            int end = toSec(str[1]);
            
            view[start] += 1;
            view[end] -= 1;
        }
        
        for (int i = 1; i <= pt;i++) {
            view[i] += view[i - 1];
        }
        
        long [] pre = new long[pt + 1];
        pre[0] = view[0];
        for (int i = 1 ; i <= pt;i++) {
            pre[i] = pre[i - 1] + view[i];
        }
        
        long max = pre[at - 1];
        int startTime = 0;
         for (int i = 1; i + at - 1 <= pt;i++) {
            int end = i + at - 1;
             
            long sum = pre[end] - pre[i - 1];
            if (sum > max) {
                max = sum;
                startTime = i;
            }
        }
        
        int ht = startTime / 3600;
        int mt = (startTime % 3600) / 60;
        int st = (startTime % 3600) % 60;
       
        
        return  String.format("%02d:%02d:%02d",ht,mt,st);
    }
    
    public int toSec(String time) {
        String [] str = time.split(":");
        int h = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int s = Integer.parseInt(str[2]);
        
        return (h * 60 * 60) + (m * 60) + s; 
    }
}