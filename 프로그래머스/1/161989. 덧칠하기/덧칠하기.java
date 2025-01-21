import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        Arrays.sort(section);
        int start = section[0];
        
        for(int i = 0; i < section.length; i++){
            if(section[i] < start + m){
                continue;
            }
            start = section[i];
            answer++;
        }
        
        return answer;
    }
}