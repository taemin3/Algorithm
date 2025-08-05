class Solution {
    public int solution(int hp) {
        int sum = hp / 5;
        sum += (hp % 5) / 3;
        sum += ((hp % 5) % 3) / 1;
        return sum;
    }
}