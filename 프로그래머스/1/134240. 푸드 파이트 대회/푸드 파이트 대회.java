class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i = 1; i < food.length; i++){
            int cnt = food[i] / 2;
            while(cnt-- > 0){
                answer += i;
            }
        }
        answer += "0";
        
        String temp = "";
        for(int i = answer.length() - 2; i >= 0; i--){
            temp += answer.charAt(i);
        }
        return answer + temp;
    }
}