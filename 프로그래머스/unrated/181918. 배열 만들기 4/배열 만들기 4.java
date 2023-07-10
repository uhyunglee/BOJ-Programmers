import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        /*ArrayList<Integer> stk = new ArrayList<>();
        int i = 0;
        while(i < arr.length){
            if(stk.size() == 0){
                stk.add(arr[i]);
                i++;
            }else{
                if(stk.get(stk.size()-1) < arr[i]){
                    stk.add(arr[i]);
                    i++;
                }else{
                    stk.remove(stk.size()-1);
                }
            }
        }
        int[] answer = new int[stk.size()];
        for(int j=0; j<stk.size(); j++){
            answer[j] = stk.get(j);
        }
        return answer;*/
        
        Stack<Integer> stack = new Stack();
        for(int i : arr){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && i <= stack.peek()){
                stack.pop();
            }
            stack.push(i);
        }
        int[] answer = new int[stack.size()];
        for(int i = 0; i<answer.length;i++){
            answer[answer.length - 1 - i] = stack.pop();
        }
        return answer;
    }
}