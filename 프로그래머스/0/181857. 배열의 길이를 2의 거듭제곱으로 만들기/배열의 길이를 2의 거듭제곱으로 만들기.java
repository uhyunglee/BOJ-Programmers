class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        int cnt = 1;
        while(cnt < n){
            cnt *= 2;
        }
        // 2의 거듭제곱의 배열 생성하기 
        int[] answer = new int[cnt];
        
        for(int i = 0; i < arr.length; i++){
            answer[i] = arr[i];
        }
        
        return answer;
    }
}