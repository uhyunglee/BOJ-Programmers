class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String numStr = num + "";
        
        for(int i = 0 ; i < numStr.length(); i++){
            if(numStr.charAt(i) == Character.forDigit(k, 10)){
                answer = i + 1;
                break;
            }
        }
        if(answer == 0) answer = -1;
        return answer;
    }
}