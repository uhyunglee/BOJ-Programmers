import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap();
        String answer = "";
    
        for (int i = 0; i < participant.length; i++) {
            if (hashMap.get(participant[i]) != null) {
                hashMap.put(participant[i], hashMap.get(participant[i]) + 1);
            } else {
                hashMap.put(participant[i], 1);
            }

        }

        for (int i = 0; i < completion.length; i++) {
            if (hashMap.get(completion[i]) != null) {
                hashMap.put(completion[i], hashMap.get(completion[i]) - 1);
            }

        }

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }
}