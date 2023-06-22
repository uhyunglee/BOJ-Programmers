class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        char[] strArr1 = str1.toCharArray();
        char[] strArr2 = str2.toCharArray();
        
        for(int i = 0; i< str1.length(); i++){
            answer += Character.toString(strArr1[i]);
            answer += Character.toString(strArr2[i]);
        }
        return answer;
    }
}