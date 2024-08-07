import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        ArrayList<Integer> deleteList = new ArrayList<>(Arrays.stream(delete_list).boxed().collect(Collectors.toList()));
        
        for(int i = 0; i < deleteList.size(); i++){
            if(arrList.contains(deleteList.get(i))) arrList.remove(deleteList.get(i));
        }
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}