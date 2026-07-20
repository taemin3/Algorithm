import java.util.*;
class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        
        int n = cards.length;
        
        Set<Integer> my = new HashSet<>();
        Set<Integer> get = new HashSet<>();
        
        for (int i = 0; i < n/3;i++) {
            my.add(cards[i]);
        }
        int anw = 1;
        for (int i = n/3;i < n;i+=2) {
            get.add(cards[i]);
            get.add(cards[i+1]);
            
            if (remove(my,my,n+1)) {
                anw++;
                continue;
            }
            if (coin >= 1 && remove(my,get,n+1)) {
                coin--;
                anw++;
                continue;
            }
            if (coin >= 2 && remove(get,get,n+1)) {
                coin -= 2;
                anw++;
                continue;
            }
            break;
            
            
            
        }
        
        return anw;
    }
    
    public boolean remove(Set<Integer> one, Set<Integer> two, int t) {
        for (int o : one) {
            if (two.contains(t - o)) {
                one.remove(o);
                two.remove(t-o);
                return true;
            }
        }
        return false;
    }
}