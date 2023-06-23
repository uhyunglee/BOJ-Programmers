class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        String operator = ineq+eq;
        int answer = 0;
        
        switch(operator){
            case ">=":
                if(n >= m) answer = 1;break;
            case "<=":
                if(n <= m) answer = 1;break;
            case ">!":
                if(n > m) answer = 1;break;
            case "<!":
                if(n < m) answer = 1;break;
            default: answer = 0;
        }
            return answer;
    }
}