import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> li = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(flag[i] == true){
                for(int j = 0; j < arr[i] * 2; j++){
                    li.add(arr[i]);
                }
            }else{
                for(int j = 0; j < arr[i]; j++){
                    li.remove(li.size()-1);
                }
            }
        }
        int[] answer = new int[li.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = li.get(i);
        }
        
        return answer;
    }
}