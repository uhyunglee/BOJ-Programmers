import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // hashmap에 이름 번호 저장 
        // 사진을 순회하면서 해쉬맵에 해당하는 키가 있으면 점수 더함 
        HashMap<String, Integer> map = new HashMap<>();
        // 해시맵 입력
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        
        // photo 순회 O(10,000)
        for(int i = 0; i < photo.length; i++){
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++){
                if(map.containsKey(photo[i][j])){
                    sum += map.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}