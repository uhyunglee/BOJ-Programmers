class Solution {
    public int[] solution(int n, int k) {
        int m = n / k;
        int[] answer = new int[m];
        for(int i = 1; i <= m; i++){
            answer[i-1] = i * k;
        }
        
        return answer;
    }
}