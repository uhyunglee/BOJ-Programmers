import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> stk = new ArrayList<>();
        int[] emptyArr = {-1};
        
        for(int i = 0; i < arr.length; i++){
            if(stk.isEmpty()) stk.add(arr[i]);
            else if(stk.get(stk.size()-1) == arr[i]) stk.remove(stk.size()-1);
            else if(stk.get(stk.size()-1) != arr[i]) stk.add(arr[i]);
        }
        
        int[] answer = stk.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        if(answer.length == 0)
            answer = emptyArr;
        
        return answer;
    }
}