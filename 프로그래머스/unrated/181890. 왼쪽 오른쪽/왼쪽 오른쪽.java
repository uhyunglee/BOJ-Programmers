import java.util.Arrays;

class Solution {
    public String[] solution(String[] strList) {
        String[] answer = {};
        for(int i = 0; i < strList.length; i++){
            if(strList[i].equals("l")){
                return Arrays.copyOfRange(strList, 0, i);
            }else if(strList[i].equals("r")){
                return Arrays.copyOfRange(strList, i+1, strList.length);
            }
        }
        return answer;
    }
}