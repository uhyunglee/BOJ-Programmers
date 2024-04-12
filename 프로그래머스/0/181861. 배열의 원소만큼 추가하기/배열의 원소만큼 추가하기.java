class Solution {
    public int[] solution(int[] arr) {
        int length = 0;
        for(int i = 0; i < arr.length; i++){
            length += arr[i];
        }
        int[] answer = new int[length];
        
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            int cnt = arr[i];
            while(cnt-- > 0){
                answer[j++] = arr[i];
            }
        }
        
        return answer;
    }
}