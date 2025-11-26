import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        int k = timetable.length;
        
        int[] time = new int[k];
        
        for (int i = 0 ;i < timetable.length;i++) {
            String[] str = timetable[i].split(":");
            int h = Integer.parseInt(str[0]);
            int mm = Integer.parseInt(str[1]);
            
            time[i] = h * 60 + mm;
        }
        
        Arrays.sort(time);
        int bus = 540;
        int idx = 0;
        int last = 0;
        int anw = 0;
        
        
        
        for (int i = 0;i < n;i++) {
            int count = 0;
            while(idx < k && time[idx] <= bus && count < m) {
                last = time[idx];
                idx++;
                count++;
            }
            
            if (i == n - 1) {
                if (count < m) {
                    anw = bus;
                } else {
                    anw = last - 1;
                }
            }
            
            bus += t;
        }
        
        int ah = anw / 60;
        int am = anw % 60;
        
        return String.format("%02d:%02d", ah, am);
    }
}