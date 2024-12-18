import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++){
            int tempRank = map.get(callings[i]) - 1;
            String tempPlayer = players[tempRank];
            
            // 배열 갱신
            players[tempRank] = callings[i];
            players[tempRank + 1] = tempPlayer;
            
            // map 갱신
            map.put(callings[i], tempRank);
            map.put(tempPlayer, tempRank + 1);
        }
        
        
        return players;
    }
}