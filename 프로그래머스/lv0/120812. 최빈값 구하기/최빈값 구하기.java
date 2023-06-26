import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int count = 0;
        int[] countArray = new int[1001];
        
        for(int i=0; i<array.length; i++){
            countArray[array[i]]++;
        }
        
        int max = 0;
        int maxIndex = 0;
        
        for(int i=0; i<countArray.length; i++){
            if(countArray[i] > max){
                max = countArray[i];
                maxIndex = i;
            }
        }
        
        for(int i = 0; i < countArray.length; i++){
            if(countArray[i] == max) count++;
        }
        
        if(count > 1) return -1;
        answer = maxIndex;
        
        return answer;
        
       
    }
}