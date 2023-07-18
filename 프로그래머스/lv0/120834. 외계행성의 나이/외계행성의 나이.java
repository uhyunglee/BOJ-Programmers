class Solution {
    public String solution(int age) {
        String intString = Integer.toString(age);
        StringBuffer sb = new StringBuffer();
        
        for(int i=0;i<intString.length();i++){
            sb.append((char)(intString.charAt(i) + '1'));
        }
        
        return sb.toString();
    }
}