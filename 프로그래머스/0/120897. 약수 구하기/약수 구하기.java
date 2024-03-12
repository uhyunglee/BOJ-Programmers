import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            if(n%i == 0){
                list.add(i);
                cnt++;
            }
        }
        int[] answer = new int[cnt];
        for(int j = 0; j < list.size(); j++){
            answer[j] = list.get(j);
        }
        
        
        return answer;
    }
}