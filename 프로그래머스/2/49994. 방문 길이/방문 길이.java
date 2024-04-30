import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 5, y = 5;
        HashMap<Character, int[]> location = new HashMap<>();
        HashSet<String> answer = new HashSet<>();
        
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
        
        for(int i = 0; i < dirs.length(); i++){
            int[] offset = location.get(dirs.charAt(i));
            int dx = x + offset[0];
            int dy = y + offset[1];
            
            if(dx < 0 || dx > 10 || dy < 0 || dy > 10) continue;
            answer.add(x + " " + y + " " + dx + " " + dy);
            answer.add(dx + " " + dy + " " + x + " " + y);
            x = dx;
            y = dy;
        }
        return answer.size() / 2;
    }
}