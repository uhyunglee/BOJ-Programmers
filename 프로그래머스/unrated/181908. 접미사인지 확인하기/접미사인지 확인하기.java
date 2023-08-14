class Solution {
    public int solution(String myString, String isSuffix) {
        int answer = 0;
        String[] stringArray = new String[myString.length()];
        StringBuffer sb = new StringBuffer("isSuffix");
        
        for(int i = 0; i < myString.length(); i++){
            stringArray[i] = myString.substring(i);
            if(isSuffix.equals(stringArray[i])){
                answer = 1;
            }
        }
        return answer;
    }
}