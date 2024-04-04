import java.util.StringTokenizer;

class Solution {
    public int solution(String binomial) {
        StringTokenizer st = new StringTokenizer(binomial);
        int num1 = Integer.parseInt(st.nextToken());
        char op = st.nextToken().charAt(0);
        int num2 = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        
        switch(op){
            case '+':
                return answer = num1 + num2;
            case '-':
                return answer = num1 - num2;
            case '*':
                return answer = num1 * num2;
            default: break;
        }
        return answer;
    }
}