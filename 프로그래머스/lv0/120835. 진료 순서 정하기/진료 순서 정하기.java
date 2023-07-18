import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[emergency.length];

        for(int i : emergency){
            list.add(i);
        }
        Collections.sort(list, Collections.reverseOrder());

        for(int j=0; j<emergency.length; j++){
            answer[j] = list.indexOf(emergency[j]) + 1;
        }

        return answer;
    }
}