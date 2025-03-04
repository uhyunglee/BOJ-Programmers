import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        int length = survey.length;
        for(int i = 0; i < length; i++){
            StringBuilder sb = new StringBuilder(survey[i]);
            if(choices[i] <= 3){// 비동의
                char c = sb.charAt(0);
                if(choices[i] == 1){
                    map.put(c, map.get(c) + 3);
                }else if(choices[i] == 2){
                    map.put(c, map.get(c) + 2);
                    
                }else
                    map.put(c, map.get(c) + 1);
            }else if(choices[i] >= 5){// 동의
                char c = sb.charAt(1);
                if(choices[i] == 7){
                    map.put(c, map.get(c) + 3);
                }else if(choices[i] == 6){
                    map.put(c, map.get(c) + 2);
                    
                }else
                    map.put(c, map.get(c) + 1);
            }
        }
        
        // 비교 같으면 알파벳 순
        String answer = "";
        if(map.get('R') >= map.get('T')){
            answer+= 'R';
        }else if(map.get('R') < map.get('T')){
            answer += 'T';
        }
        if(map.get('C') >= map.get('F')){
            answer += 'C';
        }else if(map.get('C') < map.get('F')){
            answer += 'F';
        }
        if(map.get('J') >= map.get('M')){
            answer += 'J';
        }else if(map.get('J') < map.get('M')){
            answer += 'M';
        }
        if(map.get('A') >= map.get('N')){
            answer += 'A';
        }else if(map.get('A') < map.get('N')){
            answer += 'N';
        }
        return answer;
    }
}