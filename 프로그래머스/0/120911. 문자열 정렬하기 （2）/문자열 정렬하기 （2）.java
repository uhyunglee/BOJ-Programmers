import java.util.*;

class Solution {
    public String solution(String my_string) {
        String[] myString = my_string.toLowerCase().split("");
        Arrays.sort(myString);
        String answer = "";
        for(String str : myString){
            answer += str;
        }
        return answer;
        
    }
}