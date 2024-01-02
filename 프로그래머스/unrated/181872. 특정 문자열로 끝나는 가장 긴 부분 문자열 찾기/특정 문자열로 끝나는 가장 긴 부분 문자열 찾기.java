class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        int idx = myString.lastIndexOf(pat) + pat.length();
        for(int i = 0; i < idx; i++){
            answer += myString.charAt(i);
        }
        return answer;
    }
}