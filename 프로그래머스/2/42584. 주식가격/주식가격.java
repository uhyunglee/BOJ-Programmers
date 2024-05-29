import java.util.Stack;

class Solution {

    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n]; 

        // 스택(stack)을 사용해 이전 가격과 현재 가격 비교
        Stack<Integer> stack = new Stack<>(); 
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }

        return answer;
    }

}