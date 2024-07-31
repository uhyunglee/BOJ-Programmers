import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(String str : strArr){
            map.put(str.length(), map.getOrDefault(str.length(), 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        
        int max = 0;
        for(int i = 0; i < list.size(); i++){
            if(max < map.get(list.get(i))){
                max = map.get(list.get(i));
            }
        }
        
        int answer = max;
        return answer;
    }
}