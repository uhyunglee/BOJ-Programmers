class Solution {
    public int[] solution(int[] numList) {
        int length = numList.length;
        int[] answer = new int[length+1];
        
        for(int i = 0 ; i < length; i++){
            answer[i] = numList[i];
        }
        if(numList[length - 1] > numList[length - 2]){
           answer[length] = numList[length - 1] - numList[length - 2];
        }else
            answer[length] = 2 * numList[length - 1];
        
        return answer;
    }
}