class Solution {
    public String solution(String myString, int n) {
        String answer = "";
        int length = myString.length();
        char[] myArr = new char[length];
        
        for(int i = 0; i < myString.length(); i++){
            myArr[i] = myString.charAt(i);
        }
        
        for(int j = 0; j < n; j++){
            answer+= myArr[length-n +j];
        }
        
        return answer;
    }
}