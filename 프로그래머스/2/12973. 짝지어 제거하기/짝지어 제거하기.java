import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        if(s.length() % 2 == 1) return 0;
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(stack.empty()) stack.push(s.charAt(i));
            else{
            	if(stack.peek() == s.charAt(i))
            	    stack.pop();
            	else
            	    stack.push(s.charAt(i));
            }
        }

        return stack.empty() ? 1 : 0;
    }
}