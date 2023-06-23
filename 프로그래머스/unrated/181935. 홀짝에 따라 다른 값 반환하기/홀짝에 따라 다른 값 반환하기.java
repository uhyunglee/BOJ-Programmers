class Solution {
    public int solution(int n) {
        int answer = 0;
        switch(n%2){
   
        case 0:
       		int i = 0;
       		while(i<=n){
                answer += i*i;
                i+=2;
            }
        	break;
        case 1:
        		int j = 1;
        		while(j<=n){
                    answer += j;
                    j+=2;
                }
                break;
        }
        return answer;
    }
}