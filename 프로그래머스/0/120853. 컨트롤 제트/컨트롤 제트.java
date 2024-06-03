import java.util.*;

class Solution {
    public int solution(String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(s);
        
        while(st.hasMoreTokens()){
            stack.push(st.nextToken());
        }
        
        int answer = 0;
        
        while(!stack.isEmpty()){
            String str = stack.pop();
            if(str.equals("Z"))
            	stack.pop();
            else
                answer += Integer.parseInt(str);
        }
        return answer;
    }
}