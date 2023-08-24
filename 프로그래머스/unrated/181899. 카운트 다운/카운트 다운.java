class Solution {
    public int[] solution(int start, int end) {
        int[] answer = new int[start - end + 1];
        int count = 0; 
        int i = start;
        while(i >= end){
            answer[count++] = i--;
        }
        return answer;
    }
}