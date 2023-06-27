class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        int sum =0;
        
        for(int nums : numbers){
           sum += nums; 
        }
        answer = (double)sum / (double)numbers.length;
        return answer;
    }
}