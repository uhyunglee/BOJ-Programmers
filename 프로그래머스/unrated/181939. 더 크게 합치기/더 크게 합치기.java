class Solution {
    public int solution(int a, int b) {
        try{
            int answer = 0;
     		String answer1 = "" + a + b;
       		String answer2 = "" + b + a;
        
        	if(Integer.parseInt(answer1) < Integer.parseInt(answer2)){
        	    answer = Integer.parseInt(answer2);
        	}else
           	 answer = Integer.parseInt(answer1);
        
       	 	return answer;
        }catch(NumberFormatException e){
            return 0;
        }
    }
}