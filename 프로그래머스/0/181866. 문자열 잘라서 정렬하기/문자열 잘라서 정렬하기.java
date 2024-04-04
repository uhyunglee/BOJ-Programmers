import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        ArrayList<String> li = new ArrayList<>();
        Arrays.sort(answer);
        for(int i = 0; i < answer.length; i++){
            if(!answer[i].isEmpty())
                li.add(answer[i]);
        }
        String[] ans = new String[li.size()];
        for(int i = 0; i < li.size(); i++){
            ans[i] = li.get(i);
        }
        return ans;
    }
}