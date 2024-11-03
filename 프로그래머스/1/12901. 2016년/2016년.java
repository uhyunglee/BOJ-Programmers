class Solution {
    public String solution(int a, int b) {
        // 2016.01.01 -> FRI
        String answer = "";
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] sum = new int[13];
       	
        for(int i = 1; i < 12; i++){
            sum[i] = sum[i-1] + months[i-1];
        }
        int today = sum[a - 1] + b - 1; // b-1은 왜하지
        
        return days[today%7];
    }
}