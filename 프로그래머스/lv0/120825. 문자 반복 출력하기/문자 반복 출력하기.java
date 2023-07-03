class Solution {
    public String solution(String myString, int n) {
        String answer = "";
        
        for(int i=0; i<myString.length(); i++){
            for(int j=0; j<n; j++){
                answer += myString.charAt(i);
            }
        }
        return answer;
    }
}