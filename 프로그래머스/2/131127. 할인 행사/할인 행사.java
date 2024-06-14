import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // discount length - 3 만큼 순회하기
        // 
        int days = 0;
        int n = discount.length;
        HashMap<String, Integer> buyMap = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){ // 해시맵 값 입력
            buyMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i < n - 9; i++){
        	HashMap<String, Integer> discountMap = new HashMap<>();
            for(int j = i; j < i + 10; j++){
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }
            if(buyMap.equals(discountMap))
                days++;
        }
        return days;
    }
}