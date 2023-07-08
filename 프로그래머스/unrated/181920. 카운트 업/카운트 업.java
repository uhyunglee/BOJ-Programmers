class Solution {
    public int[] solution(int start, int end) {
        int length = end - start + 1;
        int[] answer = new int[end-start+1];
        
        for(int i = 0; i < length; i++){
            answer[i] = start+i;
        }
        return answer;
    }
}