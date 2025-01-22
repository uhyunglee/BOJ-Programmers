class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+2];
        for(int i : lost){
            students[i]--;
        }
        for(int i : reserve){
            students[i]++;
        }
        for(int i = 1; i < students.length-1; i++){
            if(students[i - 1] < 0 && students[i] >= 1){
                students[i - 1]++;
                students[i]--;
            }
            if(students[i + 1] < 0 && students[i] >= 1){
                students[i + 1]++;
                students[i]--;
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(students[i] >= 0) answer++;
        }
        return answer;
    }
}