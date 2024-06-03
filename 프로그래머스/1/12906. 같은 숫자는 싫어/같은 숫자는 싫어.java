import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != stack.peek()) stack.push(arr[i]);
        }
        int[] stackArr = new int[stack.size()];
        int[] answer = new int[stack.size()];
        
        stackArr = stack.stream().mapToInt(Integer::intValue).toArray();
        
        for(int i = 0; i < stackArr.length; i++){
            answer[i] = stackArr[stackArr.length -1 -i];
        }
        
        return answer;
    }
}