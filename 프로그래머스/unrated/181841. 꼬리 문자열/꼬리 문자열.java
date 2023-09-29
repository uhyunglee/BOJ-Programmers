

class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        StringBuffer sb = new StringBuffer(ex);
        
        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].contains(ex))
                continue;
            else answer += str_list[i];
        }
        return answer;
    }
}