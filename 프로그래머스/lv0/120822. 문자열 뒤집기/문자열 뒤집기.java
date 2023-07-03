class Solution {
    public String solution(String myString) {
        String answer = "";
        int length = myString.length();
        
        for(int i = 0; i < length; i++){
            answer += myString.charAt(length- (1 + i));
        }
        return answer;
    }
}