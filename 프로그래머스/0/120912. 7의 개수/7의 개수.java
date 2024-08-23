class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int arr : array){
            while(arr > 0){
            	if(arr % 10 == 7){
            	    answer++;
            	    arr /= 10;
            	}else
                    arr /= 10;
            }
        }
        return answer;
    }
}