import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(list.size() == k) break;
            if(!list.contains(arr[i]))
                list.add(arr[i]);
        }
        
        while(list.size() < k){
            list.add(-1);
        }
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}