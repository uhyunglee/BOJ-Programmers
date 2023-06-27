class Solution {
    public int solution(int n) {
        int answer = 0;
        int lcm = 1;
        int i = 2;
        int m = 6;
        while(true){
            if(n % i == 0 && m % i == 0){
                lcm *= i;
                n /= i;
                m /= i; 
            }else{
                i++;
            }
            if(i==6) break;
        }
        lcm = lcm * n * m;
        answer = lcm / 6;
        
        
        return answer;
    }
}