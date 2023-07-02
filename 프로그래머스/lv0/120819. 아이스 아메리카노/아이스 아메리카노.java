class Solution {
    public int[] solution(int money) {
        int[] answer = {0, 0};
        int americano = money / 5500;
        int change = money % 5500;
        answer[0] = americano;
        answer[1] = change;
        
        return answer;
    }
}