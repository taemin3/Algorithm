class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        int n = lines.length;
        int [][] time = new int[n][2];
        
        for (int i = 0 ; i < n;i++) {
            String[] str = lines[i].split(" ");
            String [] tStr = str[1].split(":");
            int h = Integer.parseInt(tStr[0]) * 3600 * 1000;
            int m = Integer.parseInt(tStr[1]) * 60 * 1000;
            int s = (int) (Double.parseDouble(tStr[2]) * 1000);
            time[i][1] = h + m + s;
            String du = str[2].replace("s","");
            int s1 = (int) (Double.parseDouble(du) * 1000);
            time[i][0] = time[i][1] - s1 + 1;
        }
        int max = 0;
        
        for (int i = 0 ; i < n;i++) {
            int count = 0;
            for (int[] t : time) {
                if (t[0] <= time[i][1] + 999 && t[1]  >= time[i][1]) {
                    count++;
                }
            }
            max = Math.max(count,max);
        }
        
        return max;
    }
}