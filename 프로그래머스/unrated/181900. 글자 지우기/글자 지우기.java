import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String[] tmp = my_string.split("");
        
        for(int i = 0; i < indices.length; i++){
            tmp[indices[i]] = "";
        }
        
        for(String a : tmp){
            answer += a;
        }
        return answer;
    }
}