class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if(Character.isUpperCase(c)){
                answer += String.valueOf(c).toLowerCase();
            }else
                answer += String.valueOf(c).toUpperCase();
        }
        return answer;
    }
}