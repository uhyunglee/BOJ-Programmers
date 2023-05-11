import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()){
            switch(c) {
                    case '(' -> stack.push(c);
                    case ')' -> {
                        if(stack.isEmpty()) return false;
                        stack.pop();
                    }
            }
        }
        return stack.isEmpty();
    }
}