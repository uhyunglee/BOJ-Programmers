import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int length = String.valueOf(n).length();
        
        for(int i = 0; i < length; i+=1){
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}