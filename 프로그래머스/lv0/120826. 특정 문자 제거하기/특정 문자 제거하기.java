class Solution {
    public String solution(String myString, String letter) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<myString.length();i++){
            if(letter.charAt(0) != myString.charAt(i)){
                sb.append(myString.charAt(i));
            }
        }
        return sb.toString();
    }
}