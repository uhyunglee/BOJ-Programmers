import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> hashMap = new HashMap<>();
        for(String str : keymap){
            StringBuilder sb = new StringBuilder(str);
            for(int j = 0; j < sb.length(); j++){
                char c = sb.charAt(j);
                if(!hashMap.containsKey(c)){
                    hashMap.put(c, j + 1);
                }else{
                    if(hashMap.get(c) > j + 1){
                        hashMap.put(c, j + 1);
                    }
                }
            }
        }
        
        int i = 0;
        for(String str : targets){
            StringBuilder sb = new StringBuilder(str);
            int count = 0;
            int value = 0;
            for(int j = 0; j < sb.length(); j++){
                char c = sb.charAt(j);
                value = hashMap.getOrDefault(c, 0);
                if(value == 0) break;
                count += value;
            }
            
            answer[i++] = value == 0 ? -1 : count;
        }
        return answer;
    }
}