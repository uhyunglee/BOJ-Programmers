import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> cloth = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){ // put the clothes info into map
            String category = clothes[i][1];
            if(!cloth.containsKey(category)){
                cloth.put(category, cloth.getOrDefault(category, 0) + 1);
            }else{
                cloth.put(category, cloth.getOrDefault(category, 0) + 1);
            }
        }
        Iterator<Integer> it = cloth.values().iterator();
        
        int answer = 1;
        while(it.hasNext())
            answer *= it.next() + 1;
        
        
        return answer - 1;
    }
}