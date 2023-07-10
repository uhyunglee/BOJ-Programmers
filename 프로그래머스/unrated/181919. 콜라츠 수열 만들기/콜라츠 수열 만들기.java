import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        while(true){
            list.add(n);
            if(n == 1)break;
            n = n%2 == 0 ? n/2 : 3 * n + 1;
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}