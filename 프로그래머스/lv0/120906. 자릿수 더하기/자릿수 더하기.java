class Solution {
    public int solution(int n) {
        int answer = 0;
        String m = n + "";
        
        for(int i = 0; i < m.length(); i++){
            answer += (int)(m.charAt(i)- '0');
        }
        return answer;
    }
}