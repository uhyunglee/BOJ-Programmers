import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = {};
        for(int i=l; i<r+1; i++){
        	int count = 0;
            String intString = Integer.toString(i);
            for(int j = 0; j < intString.length(); j++){
                if(intString.charAt(j) == '0' || intString.charAt(j) == '5') 
                    count ++;
            }
            if(count == intString.length()){
                list.add(Integer.parseInt(intString));
            }
        }
       if(list.size() == 0){
           answer = new int[1];
           answer[0] = -1;
       }else answer = list.stream().mapToInt(n -> n).toArray();
        
        return answer;
    }
}