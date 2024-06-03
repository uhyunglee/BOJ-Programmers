import java.util.*;

class Solution {
    public int solution(String s) {
        String[] str = s.split(" ");
        
        ArrayDeque<String> stack = new ArrayDeque<>();
        
        for(int i = 0; i < str.length; i++){
            if(str[i].equals("Z")){
                stack.pop();
                continue;
            }else
                stack.push(str[i]);
        }
        
        int answer = 0;
        
        while(!stack.isEmpty()){
            answer += Integer.parseInt(stack.pop());
        }
        return answer;
    }
}