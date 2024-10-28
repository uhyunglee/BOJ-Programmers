import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i < arr.length; i+=1){
            if(arr[i-1] != arr[i]){
                list.add(arr[i-1]);
            }
        }
        list.add(arr[arr.length-1]);
        

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}