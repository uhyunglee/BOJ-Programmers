import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : numlist){
            if(num % n == 0)
                list.add(num);
        }
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}