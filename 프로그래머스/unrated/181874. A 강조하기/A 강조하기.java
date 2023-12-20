class Solution {
    public String solution(String myString) {
        String answer = "";
        for(int i=0; i<myString.length();i++){
            if(myString.charAt(i) == 'a'){
                answer += (char)(myString.charAt(i) - 32);
            }else if(myString.charAt(i) == 'A'){
                answer += myString.charAt(i);
            }else{
                answer += Character.toLowerCase(myString.charAt(i));
            }
        }
        return answer;
    }
}