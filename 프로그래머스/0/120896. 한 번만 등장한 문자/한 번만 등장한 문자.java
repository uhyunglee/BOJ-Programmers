import java.util.*;

class Solution {
    public String solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str : s.split("")){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        
        String answer = "";
        for(String key : list){
            if(map.get(key) == 1)
                answer += key;
        }
        return answer;
    }
}