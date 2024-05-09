import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        ArrayList<Integer> list = new ArrayList<>();
        int length = (int) (right - left + 1);
        
        while(left <= right){
            int div = (int)(left / n);
            int remainder = (int)(left % n);
            if(div >= remainder) list.add(div + 1);
            else list.add(remainder + 1);
            left++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}