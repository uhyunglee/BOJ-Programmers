import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        if(n == 1){
            return new int[]{-1};
        }
        
        for(int i = 0; i < n; i+=1){
            if(min > arr[i]) 
                min = arr[i];
        }
        for(int i = 0; i < n; i+=1){
            if(arr[i] != min){
                list.add(arr[i]);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}