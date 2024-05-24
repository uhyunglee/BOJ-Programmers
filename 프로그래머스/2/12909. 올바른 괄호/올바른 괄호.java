import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stck = new Stack<>();
        
        
        // 1) 스택에서 pop하기
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i); 
        // 2) 괄호가 짝지어지는지 체크하기
            if(c == '('){
               stck.push(c);
            }else {
                if(stck.empty() || stck.pop() == c) return false; 
            }
        }
        // 3) 올바르게 짝지어졌는지 반환
        return stck.empty();
    }
}