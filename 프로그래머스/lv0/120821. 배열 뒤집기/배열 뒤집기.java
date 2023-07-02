class Solution {
    public int[] solution(int[] numList) {
        int[] answer = new int[numList.length];
        
        for(int i = 0; i < numList.length; i++){
            answer[i] = numList[numList.length - 1 - i];
        }
        return answer;
    }
}