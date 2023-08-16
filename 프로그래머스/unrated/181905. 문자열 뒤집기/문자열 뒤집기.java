class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        String reversed = "";
        
        for(int i = e; i >= s; i--){
            reversed += my_string.charAt(i);
        }
        answer= my_string.substring(0, s) + reversed + my_string.substring(e + 1, my_string.length());
        
        
        return answer;
    }
}