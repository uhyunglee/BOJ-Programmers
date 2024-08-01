import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < rank.length; i++){
            if(attendance[i] == true)
                map.put(rank[i], i);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        
        
        int answer = map.get(list.get(0)) * 10000 + map.get(list.get(1)) * 100 + map.get(list.get(2));
        return answer;
    }
}