class Solution {
    public int solution(String myString, String pat) {
        int count = 0;
        String answer = "";
        for(int i = 0; i < myString.length(); i++){
            answer += myString.charAt(i);
            if(answer.endsWith(pat))
                count++;
        }
        
        return count;
    }
}