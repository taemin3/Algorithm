import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>(); 
        Map<String,Integer> sum = new HashMap<>();
        Map<String,Map<Integer,Integer>> music = new HashMap<>();
        
        for (int i = 0; i < plays.length;i++) {
            sum.put(genres[i], sum.getOrDefault(genres[i],0) + plays[i]);
            Map<Integer,Integer> newMap = new HashMap<>();
            newMap.put(i,plays[i]);
            if (music.containsKey(genres[i])){
                music.get(genres[i]).put(i,plays[i]);
            } else {
                music.put(genres[i], newMap);
            }   
        }
        
        List<String> gList = new ArrayList<>(sum.keySet());
        Collections.sort(gList, (a,b) -> sum.get(b) - sum.get(a));
        for (String g : gList) {
            Map<Integer,Integer> map2 = music.get(g);
            List<Integer> mList = new ArrayList<>(map2.keySet());
            Collections.sort(mList, (a,b) -> map2.get(b) - map2.get(a));
            answer.add(mList.get(0));
            if (mList.size() > 1) {
                answer.add(mList.get(1));
            }
        }
        int [] ans = new int[answer.size()];
        for (int i = 0 ; i < answer.size();i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}