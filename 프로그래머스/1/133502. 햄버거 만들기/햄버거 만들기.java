import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        
        for(int i = 0; i < ingredient.length; i++){
            list.add(ingredient[i]);
            while(list.size() >= 4){
                int n = list.size();
                if(!(list.get(n - 1) == 1
                    && list.get(n - 2) == 3
                    && list.get(n - 3) == 2
                    && list.get(n - 4) == 1))break;
                for(int j = 0; j < 4; j++){
                    list.remove(list.size() - 1);
                }
                answer++;
            }
        }
        return answer;
    }
}