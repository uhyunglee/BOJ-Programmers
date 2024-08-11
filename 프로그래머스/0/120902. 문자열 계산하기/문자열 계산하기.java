class Solution {
    public int solution(String my_string) {
        String[] num = my_string.split(" ");
        int answer = Integer.parseInt(num[0]);
        
        for(int i = 1; i < num.length; i++){
            if(i % 2 == 1){
                if(num[i].equals("+")){
                    if(i + 1 < num.length) answer += Integer.parseInt(num[i+1]);
                }else{
                    if(i + 1 < num.length) answer -= Integer.parseInt(num[i+1]);
                }
            }
        }
        return answer;
    }
}