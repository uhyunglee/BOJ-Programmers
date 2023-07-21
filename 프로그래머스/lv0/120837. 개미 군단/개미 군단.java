class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        while(true){
            if(hp >= 5){
                hp -= 5;
                answer++;
            }else if(hp >= 3 && hp < 5){
                hp -= 3;
                answer++;
            }else if(hp < 3 && hp >= 1){
                hp -= 1;
                answer++;
            }
            if(hp == 0) break;
        }
        return answer;
    }
}