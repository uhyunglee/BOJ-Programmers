import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] numList) {
        /*int[] answer = {0, 0};
        for(int i = 0; i < numList.length; i++){
            if(numList[i] % 2 == 0){
        		answer[0]++;        
            }else answer[1]++;
        }
        
        return answer;*/
        return IntStream.of((int)Arrays.stream(numList).filter(i -> i%2 ==0).count(), (int)Arrays.stream(numList).filter(i -> i%2 == 1).count()).toArray();
    }
}