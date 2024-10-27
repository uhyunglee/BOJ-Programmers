class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        
        // NOTE: 짝수 -> 대문자, 홀수 -> 소문자
        int idx = 0;
        for(int i = 0; i < s.length(); i+=1){
            if(String.valueOf(s.charAt(i)).contains(" ")){
                idx = 0;
                sb.append(String.valueOf(s.charAt(i)));
                continue;
            }else{
                if(idx % 2 == 0)
                	sb.append(String.valueOf(s.charAt(i)).toUpperCase());
                else
                    sb.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
            idx++;
        }
        return sb.toString();
    }
}