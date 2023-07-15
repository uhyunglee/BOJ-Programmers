class Solution {
    public String solution(String myString, int[] indexList) {
        String answer = "";
        for(int i=0; i<indexList.length; i++){
            answer+= myString.charAt(indexList[i]);
        }
        return answer;
    }
}