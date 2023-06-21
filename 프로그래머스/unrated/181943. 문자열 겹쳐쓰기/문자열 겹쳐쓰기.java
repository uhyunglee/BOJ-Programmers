import java.util.*;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        char[] myStringArr = my_string.toCharArray();
        
        for(int i = 0;i < s; i++){
            answer += Character.toString(myStringArr[i]);
        }
        
        answer += overwrite_string;
        
        for(int i = s + overwrite_string.length(); i < my_string.length(); i++){
            answer += Character.toString(myStringArr[i]);
        }
        System.out.println(answer);
        return answer;
    }
}