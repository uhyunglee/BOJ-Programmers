import java.util.*;
 
class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < my_string.length(); i++)
        {
            if(0 <= (int)(my_string.charAt(i) - '0') && (int)(my_string.charAt(i) - '0') <= 9)
            {
                list.add((int)(my_string.charAt(i) - '0'));
            }
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++)
        {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}