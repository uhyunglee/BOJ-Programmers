import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<>(); // 회원정보 저장 해시맵
        ArrayList<String> result = new ArrayList<>();
        int n = record.length;
        
        for(int i = 0; i < n; i++){
            String[] message = record[i].split(" ");
            String cmd = message[0];
            String userid = message[1];
            
            if(cmd.equals("Enter")){
                user.put(userid, message[2]);
                
            }else if(message[0].equals("Change")){
                user.put(userid, message[2]);
                
            }
		}
        
        for(int i = 0; i < n; i++){
            String[] message = record[i].split(" ");
            String cmd = message[0];
            String userid = message[1];
            
            if(cmd.equals("Enter")){
                result.add(user.get(userid) + "님이 들어왔습니다.");
            }else if(message[0].equals("Leave")){
                result.add(user.get(userid) + "님이 나갔습니다.");
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
}