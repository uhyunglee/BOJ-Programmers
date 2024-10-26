class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int remaindor = 0;
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        
        while(min != 0){
            remaindor = max % min;
            max = min;
            min = remaindor;
        }
        int G = max;
        int L = n * m / max;
        answer[0] = G;
        answer[1] = L;
        
        return answer;
    }
}